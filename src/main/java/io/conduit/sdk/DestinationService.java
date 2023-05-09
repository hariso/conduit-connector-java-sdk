package io.conduit.sdk;

import connector.v1.Connector;
import connector.v1.DestinationPluginGrpc;
import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;

@GrpcService
public class DestinationService extends DestinationPluginGrpc.DestinationPluginImplBase {
    @Override
    public void configure(Connector.Destination.Configure.Request request,
                          StreamObserver<Connector.Destination.Configure.Response> responseObserver) {
        System.out.println("DestinationService::configure");
        responseObserver.onNext(Connector.Destination.Configure.Response.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void start(Connector.Destination.Start.Request request,
                      StreamObserver<Connector.Destination.Start.Response> responseObserver) {
        System.out.println("DestinationService::start");
        responseObserver.onNext(Connector.Destination.Start.Response.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<Connector.Destination.Run.Request> run(StreamObserver<Connector.Destination.Run.Response> responseObserver) {
        System.out.println("DestinationService::run");
        return super.run(responseObserver);
    }

    @Override
    public void stop(Connector.Destination.Stop.Request request,
                     StreamObserver<Connector.Destination.Stop.Response> responseObserver) {
        System.out.println("DestinationService::stop");
        responseObserver.onNext(Connector.Destination.Stop.Response.newBuilder().build());
        responseObserver.onCompleted();

    }

    @Override
    public void teardown(Connector.Destination.Teardown.Request request,
                         StreamObserver<Connector.Destination.Teardown.Response> responseObserver) {
        System.out.println("DestinationService::teardown");
        responseObserver.onNext(Connector.Destination.Teardown.Response.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void lifecycleOnCreated(Connector.Destination.Lifecycle.OnCreated.Request request,
                                   StreamObserver<Connector.Destination.Lifecycle.OnCreated.Response> responseObserver) {
        System.out.println("DestinationService::lifecycleOnCreated");
        responseObserver.onNext(Connector.Destination.Lifecycle.OnCreated.Response.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void lifecycleOnUpdated(Connector.Destination.Lifecycle.OnUpdated.Request request,
                                   StreamObserver<Connector.Destination.Lifecycle.OnUpdated.Response> responseObserver) {
        System.out.println("DestinationService::lifecycleOnUpdated");
        responseObserver.onNext(Connector.Destination.Lifecycle.OnUpdated.Response.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void lifecycleOnDeleted(Connector.Destination.Lifecycle.OnDeleted.Request request, StreamObserver<Connector.Destination.Lifecycle.OnDeleted.Response> responseObserver) {
        System.out.println("DestinationService::lifecycleOnDeleted");
        responseObserver.onNext(Connector.Destination.Lifecycle.OnDeleted.Response.newBuilder().build());
        responseObserver.onCompleted();
    }
}
