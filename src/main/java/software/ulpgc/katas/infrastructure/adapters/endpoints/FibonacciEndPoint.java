package software.ulpgc.katas.infrastructure.adapters.endpoints;

import io.javalin.http.Context;
import software.ulpgc.katas.application.InvalidInputException;
import software.ulpgc.katas.application.UseCase;
import software.ulpgc.katas.infrastructure.adapters.EndPoint;

public class FibonacciEndPoint implements EndPoint {
    private final UseCase useCase;
    private final Context context;

    public FibonacciEndPoint(UseCase useCase, Context context) {
        this.useCase = useCase;
        this.context = context;
    }

    public static EndPoint use(UseCase useCase, Context context) {
        return new FibonacciEndPoint(useCase, context);
    }

    @Override
    public void execute() {
        try {
            context.result(useCase.execute(context.queryParam("n")));
        } catch (InvalidInputException e) {
            context.status(400).result(e.getMessage());
        } catch (Exception e) {
            context.status(500).result("error interno del servidor");
        }

    }
}
