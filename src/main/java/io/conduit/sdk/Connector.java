package io.conduit.sdk;

import jakarta.enterprise.context.ApplicationScoped;

public interface Connector {
    Specification specification();

    Source source();

    Destination destination();
}
