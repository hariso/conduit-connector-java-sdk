package io.conduit;

import io.conduit.grpc.GreeterGrpc;
import io.conduit.grpc.HelloReply;
import io.conduit.grpc.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HelloWorldClient {
    public static void main(String[] args) {
        // Create a channel to the server.
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9000)
                .usePlaintext()
                .build();

        // Create a Greeter client from the channel.
        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);

        // Call the SayHello method with a HelloRequest.
        HelloRequest request = HelloRequest.newBuilder()
                .setName("World")
                .build();
        HelloReply response = stub.sayHello(request);

        // Print the response message.
        System.out.println("Response: " + response.getMessage());

        // Shut down the channel.
        channel.shutdown();
    }
}
