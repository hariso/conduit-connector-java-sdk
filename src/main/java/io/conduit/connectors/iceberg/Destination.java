package io.conduit.connectors.iceberg;

import io.conduit.sdk.Parameter;
import io.conduit.sdk.Record;
import io.conduit.sdk.WriteResult;

import java.util.List;
import java.util.Map;

public class Destination implements io.conduit.sdk.Destination {
    @Override
    public Map<String, Parameter> parameters() {
        return null;
    }

    @Override
    public void configure(Map<String, String> configMap) {

    }

    @Override
    public void open() {

    }

    @Override
    public WriteResult write(List<Record> records) {
        return null;
    }

    @Override
    public void teardown() {

    }

    @Override
    public void lifecycleOnCreated(Map<String, String> config) {

    }

    @Override
    public void lifecycleOnUpdated(Map<String, String> configBefore, Map<String, String> configAfter) {

    }

    @Override
    public void lifecycleOnDeleted(Map<String, String> config) {

    }
}
