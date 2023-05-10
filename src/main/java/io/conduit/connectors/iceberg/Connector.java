package io.conduit.connectors.iceberg;

import io.conduit.sdk.Destination;
import io.conduit.sdk.Source;
import io.conduit.sdk.Specification;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;

@ApplicationScoped
public class Connector implements io.conduit.sdk.Connector {
    @Produces
    @Override
    public Specification specification() {
        return Specification.builder()
                .name("iceberg")
                .summary("An Iceberg connector for Conduit")
                .description("An Iceberg connector for Conduit")
                .version("v0.1.0")
                .author("Meroxa, Inc.")
                .build();

    }

    @Produces
    @Override
    public Source source() {
        return new io.conduit.connectors.iceberg.Source();
    }

    @Produces
    @Override
    public Destination destination() {
        return new io.conduit.connectors.iceberg.Destination();
    }
}
