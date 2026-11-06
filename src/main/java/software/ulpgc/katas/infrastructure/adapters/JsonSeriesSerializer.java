package software.ulpgc.katas.infrastructure.adapters;

import com.google.gson.Gson;
import software.ulpgc.katas.application.ports.SeriesSerializer;

public class JsonSeriesSerializer implements SeriesSerializer {
    @Override
    public String serialize(int[] series) {
        return new Gson().toJson(series);
    }
}
