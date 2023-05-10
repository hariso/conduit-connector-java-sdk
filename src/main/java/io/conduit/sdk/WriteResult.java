package io.conduit.sdk;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WriteResult {
    private final int written;
    private final Exception error;
}
