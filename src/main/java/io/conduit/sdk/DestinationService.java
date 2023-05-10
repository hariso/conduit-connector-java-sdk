package io.conduit.sdk;

import io.conduit.grpc.Destination;
import io.conduit.grpc.DestinationPluginGrpc;
import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;
import jakarta.inject.Inject;

@GrpcService
public class DestinationService extends DestinationPluginGrpc.DestinationPluginImplBase {
    @Inject
    io.conduit.sdk.Destination destination;

    @Override
    public void configure(Destination.Configure.Request request,
                          StreamObserver<Destination.Configure.Response> responseObserver) {
        System.out.println("DestinationService::configure");
        responseObserver.onNext(Destination.Configure.Response.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void start(Destination.Start.Request request,
                      StreamObserver<Destination.Start.Response> responseObserver) {
        System.out.println("DestinationService::start");
        responseObserver.onNext(Destination.Start.Response.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<Destination.Run.Request> run(StreamObserver<Destination.Run.Response> responseObserver) {
        System.out.println("DestinationService::run");
        return super.run(responseObserver);
    }

    @Override
    public void stop(Destination.Stop.Request request,
                     StreamObserver<Destination.Stop.Response> responseObserver) {
        System.out.println("DestinationService::stop");
        responseObserver.onNext(Destination.Stop.Response.newBuilder().build());
        responseObserver.onCompleted();

    }

    @Override
    public void teardown(Destination.Teardown.Request request,
                         StreamObserver<Destination.Teardown.Response> responseObserver) {
        System.out.println("DestinationService::teardown");
        responseObserver.onNext(Destination.Teardown.Response.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void lifecycleOnCreated(Destination.Lifecycle.OnCreated.Request request,
                                   StreamObserver<Destination.Lifecycle.OnCreated.Response> responseObserver) {
        System.out.println("DestinationService::lifecycleOnCreated");
        responseObserver.onNext(Destination.Lifecycle.OnCreated.Response.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void lifecycleOnUpdated(Destination.Lifecycle.OnUpdated.Request request,
                                   StreamObserver<Destination.Lifecycle.OnUpdated.Response> responseObserver) {
        System.out.println("DestinationService::lifecycleOnUpdated");
        responseObserver.onNext(Destination.Lifecycle.OnUpdated.Response.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void lifecycleOnDeleted(Destination.Lifecycle.OnDeleted.Request request, StreamObserver<Destination.Lifecycle.OnDeleted.Response> responseObserver) {
        System.out.println("DestinationService::lifecycleOnDeleted");
        responseObserver.onNext(Destination.Lifecycle.OnDeleted.Response.newBuilder().build());
        responseObserver.onCompleted();
    }
}
