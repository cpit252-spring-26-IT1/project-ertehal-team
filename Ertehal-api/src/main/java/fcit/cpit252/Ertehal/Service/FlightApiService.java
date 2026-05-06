package fcit.cpit252.Ertehal.Service;

import fcit.cpit252.Ertehal.Adapter_response.ExternalFlightResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service("flightApiService")
public class FlightApiService implements ApiService<ExternalFlightResponse> {

    private final RestTemplate restTemplate;
    private final Map<String, String> airportMap = new HashMap<>();

    public FlightApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        airportMap.put("france", "CDG");
        airportMap.put("uk", "LHR");
        airportMap.put("japan", "NRT");
        airportMap.put("egypt", "CAI");
        airportMap.put("uae", "DXB");
        airportMap.put("turkey", "IST");
        airportMap.put("usa", "JFK");
        airportMap.put("spain", "MAD");
        airportMap.put("italy", "FCO");
        airportMap.put("germany", "FRA");
    }

    @Override
    public ExternalFlightResponse fetch(String country) {
        String destination = airportMap.getOrDefault(country.toLowerCase(), "CDG");

        String url = "http://api.aviationstack.com/v1/flights"
                + "?access_key=" + "USE_ENV_VARIABLE"
                + "&arr_iata=" + destination
                + "&limit=1";

        // For now return sample data matching AviationStack format
        return new ExternalFlightResponse(
                "JED", destination, "1500.00", "SAR"
        );
    }
}