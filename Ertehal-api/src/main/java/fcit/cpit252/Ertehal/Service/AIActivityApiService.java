package fcit.cpit252.Ertehal.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fcit.cpit252.Ertehal.Adapter_response.ExternalActivityResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("activityApiService")
public class AIActivityApiService implements ApiCollectionService<ExternalActivityResponse> {

    private final RestTemplate restTemplate;

    @Value("${gemini.api.key}")
    private String apiKey;

    @Value("${gemini.model}")
    private String model;

    private final Map<String, String> countryToCity = new HashMap<>();

    public AIActivityApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        countryToCity.put("france", "Paris");
        countryToCity.put("uk", "London");
        countryToCity.put("japan", "Tokyo");
        countryToCity.put("egypt", "Cairo");
        countryToCity.put("uae", "Dubai");
        countryToCity.put("turkey", "Istanbul");
        countryToCity.put("usa", "New York");
        countryToCity.put("spain", "Madrid");
        countryToCity.put("italy", "Rome");
        countryToCity.put("germany", "Berlin");
    }

    @Override
    public List<ExternalActivityResponse> fetch(String country, int count) {
        String city = countryToCity.getOrDefault(country.toLowerCase(), country);
        int safeCount = Math.max(1, Math.min(count, 5));

        String prompt = String.format(
                "Generate %d realistic tourist activity suggestions for a traveler visiting %s. " +
                        "Return ONLY a JSON array (no markdown, no explanations) with this exact structure: " +
                        "[{\"activity_name\": \"specific real attraction or experience\", " +
                        "\"city_area\": \"neighborhood in %s\", " +
                        "\"price_sar\": realistic_price_in_SAR}, ...]. " +
                        "Include a mix of free and paid activities. Make each activity unique and authentic to %s.",
                safeCount, city, city, city
        );

        try {
            String aiResponse = callGemini(prompt);
            return parseActivityResponse(aiResponse);
        } catch (Exception e) {
            System.out.println("AI Activity error: " + e.getMessage());
            return fallbackActivities(city, safeCount);
        }
    }

    private String callGemini(String prompt) {
        String url = "https://generativelanguage.googleapis.com/v1beta/models/"
                + model + ":generateContent?key=" + apiKey;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> textPart = new HashMap<>();
        textPart.put("text", prompt);

        Map<String, Object> content = new HashMap<>();
        content.put("parts", new Object[]{textPart});

        Map<String, Object> body = new HashMap<>();
        body.put("contents", new Object[]{content});

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        return restTemplate.postForObject(url, entity, String.class);
    }

    private List<ExternalActivityResponse> parseActivityResponse(String aiResponse) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(aiResponse);
        String content = root.get("candidates").get(0)
                .get("content").get("parts").get(0)
                .get("text").asText();

        content = content.replaceAll("```json", "").replaceAll("```", "").trim();

        ExternalActivityResponse[] array = mapper.readValue(content, ExternalActivityResponse[].class);

        List<ExternalActivityResponse> activities = new ArrayList<>();
        for (ExternalActivityResponse a : array) {
            activities.add(a);
        }
        return activities;
    }

    private List<ExternalActivityResponse> fallbackActivities(String city, int count) {
        List<ExternalActivityResponse> fallback = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            fallback.add(new ExternalActivityResponse("Local Activity " + i, city, 100.0));
        }
        return fallback;
    }
}