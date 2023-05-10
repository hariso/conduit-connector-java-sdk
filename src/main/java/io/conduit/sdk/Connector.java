package io.conduit.sdk;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Connector {
    private final Specification specification;
    private final Source source;
    private final Destination destination;
}
