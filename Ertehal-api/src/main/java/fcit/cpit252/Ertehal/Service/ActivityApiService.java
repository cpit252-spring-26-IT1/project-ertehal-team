package fcit.cpit252.Ertehal.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fcit.cpit252.Ertehal.Adapter_response.ExternalActivityResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("activityApiService")
public class ActivityApiService implements ApiService<ExternalActivityResponse> {

    private final RestTemplate restTemplate;

    @Value("${geoapify.api.key}")
    private String apiKey;

    public ActivityApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ExternalActivityResponse fetch() {
        String url = "https://api.geoapify.com/v2/places"
                + "?categories=tourism.sights"
                + "&filter=rect:2.2,48.8,2.4,48.9"
                + "&limit=1"
                + "&apiKey=" + apiKey;

        try {
            String json = restTemplate.getForObject(url, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(json);
            JsonNode props = root.get("features").get(0).get("properties");

            return new ExternalActivityResponse(
                    props.has("name") ? props.get("name").asText() : "Unknown Place",
                    props.has("city") ? props.get("city").asText() : "Paris",
                    props.has("categories") ? props.get("categories").get(0).asText() : "tourism"
            );
        } catch (Exception e) {
            // Fallback if API fails during demo
            return new ExternalActivityResponse(
                    "Eiffel Tower", "Paris", "tourism.sights"
            );
        }
    }
}