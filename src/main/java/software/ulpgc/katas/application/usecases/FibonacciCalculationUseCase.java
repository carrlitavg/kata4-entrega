package software.ulpgc.katas.application.usecases;

import software.ulpgc.katas.application.InvalidInputException;
import software.ulpgc.katas.application.UseCase;
import software.ulpgc.katas.application.domain.FibonacciSeries;
import software.ulpgc.katas.application.ports.SeriesSerializer;

public class FibonacciCalculationUseCase implements UseCase {
    private final SeriesSerializer serializer;

    public FibonacciCalculationUseCase(SeriesSerializer serializer) {
        this.serializer = serializer;
    }

    @Override
    public String execute(String value) {
        return serializer.serialize(FibonacciSeries.calculate(deserialize(value)));
    }

    private int deserialize(String value) {
        if (value == null) {
            throw new InvalidInputException("Falta el parametro n");
        }

        int n;
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("n debe ser un numero entero: " + value);
        }

        if (n < 0 || n > 46) {
            throw new InvalidInputException("n debe estar entre 0 y 46");
        }

        return n;
    }
}
