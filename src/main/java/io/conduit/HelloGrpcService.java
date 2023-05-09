package io.conduit;

import io.conduit.grpc.GreeterGrpc.GreeterImplBase;
import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;

@GrpcService
public class HelloGrpcService extends GreeterImplBase {

    @Override
    public void sayHello(io.conduit.grpc.HelloRequest request, StreamObserver<io.conduit.grpc.HelloReply> responseObserver) {
        String name = request.getName();
        String message = "Hello " + name;
        responseObserver.onNext(io.conduit.grpc.HelloReply.newBuilder().setMessage(message).build());
        responseObserver.onCompleted();
    }
}