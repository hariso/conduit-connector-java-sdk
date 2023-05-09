package org.acme;

import io.conduit.grpc.Greeter;
import io.conduit.grpc.HelloRequest;
import io.quarkus.grpc.GrpcClient;
import io.smallrye.mutiny.Uni;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    @GrpcClient
    Greeter hello;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @GET
    @Path("/{name}")
    public Uni<String> hello(String name) {
        return hello
                .sayHello(HelloRequest.newBuilder().setName(name).build())
                .onItem().transform(helloReply -> helloReply.getMessage());
    }
}
