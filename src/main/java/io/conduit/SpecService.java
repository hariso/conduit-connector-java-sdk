package io.conduit;

import connector.v1.Connector;
import connector.v1.SpecifierPluginGrpc;
import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;

@GrpcService
public class SpecService extends SpecifierPluginGrpc.SpecifierPluginImplBase {
    @Override
    public void specify(Connector.Specifier.Specify.Request request,
                        StreamObserver<Connector.Specifier.Specify.Response> responseObserver) {

        responseObserver.onNext(
                Connector.Specifier.Specify.Response.newBuilder()
                        .setName("java-sdk-name")
                        .build()
        );
        responseObserver.onCompleted();
    }
}
