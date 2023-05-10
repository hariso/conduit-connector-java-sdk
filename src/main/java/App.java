import io.conduit.sdk.Connector;
import io.conduit.sdk.SDK;

public class App {
    public static void main(String... args) {
        SDK.serve(new Connector(
                null,
                null,
                null
        ));
    }
}
