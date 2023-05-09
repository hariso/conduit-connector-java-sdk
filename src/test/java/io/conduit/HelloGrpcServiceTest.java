package io.conduit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Test;

@QuarkusTest
public class HelloGrpcServiceTest {

    @GrpcClient
    io.conduit.grpc.Greeter helloGrpc;

    @Test
    public void testHello() {
        var request = io.conduit.grpc.HelloRequest.newBuilder().setName("Neo").build();
        io.conduit.grpc.HelloReply reply = helloGrpc.sayHello(request).await().atMost(Duration.ofSeconds(5));
        assertEquals("Hello Neo", reply.getMessage());
    }

}
