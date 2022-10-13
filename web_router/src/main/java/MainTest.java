import io.vertx.core.Vertx;

public class MainTest {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle("verticles.HelloVerticle");
    }
}
