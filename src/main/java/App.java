import io.conduit.connectors.iceberg.Destination;
import io.conduit.connectors.iceberg.Source;
import io.conduit.sdk.Connector;
import io.conduit.sdk.SDK;
import io.conduit.sdk.Specification;

public class App {
    public static void main(String... args) {
        Specification spec = Specification.builder()
                .name("iceberg")
                .summary("An Iceberg connector for Conduit")
                .description("An Iceberg connector for Conduit")
                .version("v0.1.0")
                .author("Meroxa, Inc.")
                .build();

        SDK.serve(new Connector(
                spec,
                new Source(),
                new Destination()
        ));
    }
}
