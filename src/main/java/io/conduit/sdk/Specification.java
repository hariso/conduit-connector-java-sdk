package io.conduit.sdk;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Specification {
    private final String name;
    private final String summary;
    private final String description;
    private final String version;
    private final String author;
}
