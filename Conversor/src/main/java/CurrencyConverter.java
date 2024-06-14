import java.io.IOException;

public class CurrencyConverter {
    private final ApiClient apiClient;

    public CurrencyConverter() {
        this.apiClient = new ApiClient();
    }

    public double convert(String fromCurrency, String toCurrency, double amount) throws IOException {
        ExchangeRates rates = apiClient.fetchExchangeRates();
        if (!rates.getResult().equals("success")) {
            throw new IOException("Failed to fetch exchange rates");
        }
        double fromRate = rates.getConversion_rates().get(fromCurrency);
        double toRate = rates.getConversion_rates().get(toCurrency);
        return (amount / fromRate) * toRate;
    }
}
