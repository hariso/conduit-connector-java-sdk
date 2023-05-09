import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class App {
    public static void main(String... args) {
        int port = 9000; // default
        System.out.printf("1|1|tcp|localhost:%d|grpc%n", port);
        Quarkus.run(args);
    }
}
