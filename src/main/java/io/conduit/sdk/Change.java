package io.conduit.sdk;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Change {
    private final Data before;
    private final Data after;
}
