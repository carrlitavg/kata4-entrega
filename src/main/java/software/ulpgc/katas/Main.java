package software.ulpgc.katas;

import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;
import software.ulpgc.katas.infrastructure.adapters.endpoints.HolaEndPoint;

public class Main {
    private static final int PORT = 8081;

    static void main() {
        Javalin javalin = Javalin.create(config -> create(config));
    }

    private static void create(JavalinConfig config) {
        config.routes.get("/hola/{name}", context-> HolaEndPoint.use(context).execute());
    }
}
