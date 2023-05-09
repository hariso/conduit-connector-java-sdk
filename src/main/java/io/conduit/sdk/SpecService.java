package io.conduit.sdk;

import connector.v1.Connector;
import connector.v1.SpecifierPluginGrpc;
import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;

import static java.util.Collections.emptyMap;

@GrpcService
public class SpecService extends SpecifierPluginGrpc.SpecifierPluginImplBase {
    @Override
    public void specify(Connector.Specifier.Specify.Request request,
                        StreamObserver<Connector.Specifier.Specify.Response> responseObserver) {

        responseObserver.onNext(
                Connector.Specifier.Specify.Response.newBuilder()
                        .setName("java-sdk-name")
                        .setSummary("Conduit Connector Java SDK")
                        .setDescription("Conduit Connector Java SDK -- description")
                        .setVersion("v0.1.0")
                        .setAuthor("Meroxa, Inc.")
                        .putAllDestinationParams(emptyMap())
                        .putAllSourceParams(emptyMap())
                        .build()
        );
        responseObserver.onCompleted();
    }
}
