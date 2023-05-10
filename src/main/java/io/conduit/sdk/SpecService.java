package io.conduit.sdk;

import io.conduit.grpc.Specifier;
import io.conduit.grpc.SpecifierPluginGrpc;
import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;

import static java.util.Collections.emptyMap;

@GrpcService
public class SpecService extends SpecifierPluginGrpc.SpecifierPluginImplBase {
    private Specification specification;

    @Override
    public void specify(Specifier.Specify.Request request,
                        StreamObserver<Specifier.Specify.Response> responseObserver) {

        responseObserver.onNext(
                Specifier.Specify.Response.newBuilder()
                        .setName(specification.getName())
                        .setSummary(specification.getSummary())
                        .setDescription(specification.getDescription())
                        .setVersion(specification.getVersion())
                        .setAuthor(specification.getAuthor())
                        .putAllDestinationParams(emptyMap())
                        .putAllSourceParams(emptyMap())
                        .build()
        );
        responseObserver.onCompleted();
    }
}
