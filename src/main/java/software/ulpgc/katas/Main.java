package software.ulpgc.katas;

import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;

public class Main {
    private static final int PORT = 8081;

    static void main() {
        Javalin javalin = Javalin.create(config -> create(config));
    }

    private static void create(JavalinConfig config) {
        config.routes.get("/hola", c-> c.result("Hola Mundo"));
    }
}
