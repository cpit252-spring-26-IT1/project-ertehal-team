package fcit.cpit252.Ertehal.Service;

import fcit.cpit252.Ertehal.Adapter_response.ExternalFlightResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("flightApiService")
public class FlightApiService implements ApiService<ExternalFlightResponse> {

    @Value("${duffel.api.key}")
    private String apiKey;

    @Override
    public ExternalFlightResponse fetch() {
        // Duffel requires a complex POST request with offer requests.
        // For the demo, we return realistic sample data that matches
        // the exact format Duffel would return.
        // The Adapter pattern is still justified because:

        return new ExternalFlightResponse(
                "JED", "CDG", "1500.00", "USD"
        );
    }
}