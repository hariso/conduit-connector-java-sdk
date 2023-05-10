package io.conduit.connectors.iceberg;

import java.util.Collection;

public class CollectionUtils {
    public static <T> int size(Collection<T> collection) {
        return collection == null ? 0 : collection.size();
    }
}
