import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class App {
    public static void main(String... args) {
        new Thread(() -> {
            // todo this is soooo dirty...
            // ... but it works!
            try {
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int port = 9000; // default
            System.out.printf("1|1|tcp|localhost:%d|grpc%n", port);
        }).start();
        Quarkus.run(args);
    }
}
