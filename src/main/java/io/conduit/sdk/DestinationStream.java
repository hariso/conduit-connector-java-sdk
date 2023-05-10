package io.conduit.sdk;

import io.conduit.grpc.Destination;
import io.grpc.stub.StreamObserver;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.jboss.logging.Logger;

import java.util.List;

public class DestinationStream implements StreamObserver<Destination.Run.Request> {
    private static final Logger logger = Logger.getLogger(DestinationStream.class);

    private final io.conduit.sdk.Destination destination;
    private final StreamObserver<Destination.Run.Response> responseObserver;

    public DestinationStream(io.conduit.sdk.Destination destination,
                             StreamObserver<Destination.Run.Response> responseObserver) {
        this.destination = destination;
        this.responseObserver = responseObserver;
    }

    @Override
    public void onNext(Destination.Run.Request request) {
        // todo batching
        WriteResult result = destination.write(
            List.of(Record.fromGRPC(request.getRecord()))
        );
        Destination.Run.Response.Builder responseB = Destination.Run.Response.newBuilder()
            .setAckPosition(request.getRecord().getPosition());

        if (result.getError() != null) {
            responseB.setError(result.getError().getMessage() + "\n" + ExceptionUtils.getStackTrace(result.getError()));
        }

        responseObserver.onNext(responseB.build());
    }

    @Override
    public void onError(Throwable throwable) {
        logger.warn("onError called", throwable);
        responseObserver.onError(throwable);
    }

    @Override
    public void onCompleted() {
        logger.info("onCompleted called");
        responseObserver.onCompleted();
    }
}
