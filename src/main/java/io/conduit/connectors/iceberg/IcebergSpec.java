package io.conduit.connectors.iceberg;

import io.conduit.sdk.Specification;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class IcebergSpec implements Specification {
    @Override
    public String name() {
        return "iceberg";
    }

    @Override
    public String summary() {
        return "an iceberg connector";
    }

    @Override
    public String description() {
        return "an iceberge connector";
    }

    @Override
    public String version() {
        return "v0.1.0";
    }

    @Override
    public String author() {
        return "Meroxa, Inc.";
    }
}
