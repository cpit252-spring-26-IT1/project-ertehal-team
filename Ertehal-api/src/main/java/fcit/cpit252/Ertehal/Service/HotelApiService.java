package fcit.cpit252.Ertehal.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fcit.cpit252.Ertehal.Adapter_response.ExternalHotelResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service("hotelApiService")
public class HotelApiService implements ApiService<ExternalHotelResponse> {

    private final RestTemplate restTemplate;
    private final Map<String, String> coordinatesMap = new HashMap<>();

    @Value("${geoapify.api.key}")
    private String apiKey;

    public HotelApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        coordinatesMap.put("france", "2.2,48.8,2.4,48.9");
        coordinatesMap.put("uk", "-0.2,51.4,0.0,51.6");
        coordinatesMap.put("japan", "139.6,35.6,139.8,35.8");
        coordinatesMap.put("egypt", "31.1,29.9,31.4,30.1");
        coordinatesMap.put("uae", "55.2,25.1,55.4,25.3");
        coordinatesMap.put("turkey", "28.9,40.9,29.1,41.1");
        coordinatesMap.put("usa", "-74.1,40.7,-73.9,40.8");
        coordinatesMap.put("spain", "-3.8,40.3,-3.6,40.5");
        coordinatesMap.put("italy", "12.4,41.8,12.6,42.0");
        coordinatesMap.put("germany", "13.3,52.4,13.5,52.6");
    }

    @Override
    public ExternalHotelResponse fetch(String country) {
        String key = country.toLowerCase();
        String coords = coordinatesMap.getOrDefault(key, "2.2,48.8,2.4,48.9");

        String url = "https://api.geoapify.com/v2/places"
                + "?categories=accommodation.hotel"
                + "&filter=rect:" + coords
                + "&limit=1"
                + "&apiKey=" + apiKey;

        try {
            String json = restTemplate.getForObject(url, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(json);
            JsonNode features = root.get("features");

            if (features != null && features.size() > 0) {
                JsonNode props = features.get(0).get("properties");
                String hotelName = props.has("name") ? props.get("name").asText() : "Grand Hotel";
                String city = props.has("city") ? props.get("city").asText() : country;

                return new ExternalHotelResponse(
                        hotelName, city, "2500.00", 5
                );
            }
        } catch (Exception e) {
            System.out.println("Geoapify Hotel error: " + e.getMessage());
        }

        return new ExternalHotelResponse(
                "Grand Hotel", country, "2000.00", 5
        );
    }
}