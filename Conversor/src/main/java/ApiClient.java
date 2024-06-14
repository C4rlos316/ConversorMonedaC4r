import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class ApiClient {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/7572ca5d1d527612648e8c50/latest/USD";
    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();

    public ExchangeRates fetchExchangeRates() throws IOException {
        Request request = new Request.Builder()
                .url(API_URL)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return gson.fromJson(response.body().string(), ExchangeRates.class);
        }
    }
}
