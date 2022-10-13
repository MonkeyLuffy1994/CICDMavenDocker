package verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import lib_test.TestLib;

public class HelloVerticle extends AbstractVerticle {
    @Override
    public void start() {
        Router router = Router.router(vertx);
        router.route().handler(routingContext -> {
            routingContext.response().putHeader("content-type", "text/html").end("Hello World ==== " + TestLib.TEST);
        });
        vertx.createHttpServer().requestHandler(router).listen(8080);
        System.out.println("Start Success. =======================");
    }
}
