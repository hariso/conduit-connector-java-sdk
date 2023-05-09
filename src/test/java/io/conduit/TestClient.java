package io.conduit;

import connector.v1.Connector;
import connector.v1.DestinationPluginGrpc;
import connector.v1.SpecifierPluginGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class TestClient {
    public static void main(String[] args) {
        // Create a channel to the server.
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9000)
                .usePlaintext()
                .build();

        // Create a Greeter client from the channel.
        var stub = DestinationPluginGrpc.newBlockingStub(channel);

        // Call the SayHello method with a HelloRequest.
        var request = connector.v1.Connector.Destination.Configure.Request.newBuilder()
                .build();
        var response = stub.configure(request);

        // Print the response message.
        System.out.println("Response: " + response);

        // Shut down the channel.
        channel.shutdown();
    }
}
