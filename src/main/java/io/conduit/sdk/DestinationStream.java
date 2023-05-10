package io.conduit.sdk;

import io.conduit.grpc.Destination;
import io.grpc.stub.StreamObserver;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.List;

public class DestinationStream implements StreamObserver<Destination.Run.Request> {
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
        Destination.Run.Response.Builder responseB = Destination.Run.Response.newBuilder();
        if (result.getError() != null) {
            responseB.setError(result.getError().getMessage() + "\n" + ExceptionUtils.getStackTrace(result.getError()));
        } else {
            responseB.setAckPosition(request.getRecord().getPosition());
        }
        responseObserver.onNext(responseB.build());
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onCompleted() {
        responseObserver.onCompleted();
    }
}
