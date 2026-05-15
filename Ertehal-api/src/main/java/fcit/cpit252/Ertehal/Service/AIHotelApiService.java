package fcit.cpit252.Ertehal.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fcit.cpit252.Ertehal.Adapter_response.ExternalHotelResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service("hotelApiService")
public class AIHotelApiService implements ApiService<ExternalHotelResponse> {

    private final RestTemplate restTemplate;

    @Value("${gemini.api.key}")
    private String apiKey;

    @Value("${gemini.model}")
    private String model;

    private final Map<String, String> countryToCity = new HashMap<>();

    public AIHotelApiService(RestTemplate restTemplate) {
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
    public ExternalHotelResponse fetch(String country) {
        String city = countryToCity.getOrDefault(country.toLowerCase(), country);

        String prompt = String.format(
                "Generate a realistic hotel suggestion for a traveler visiting %s. " +
                        "Return ONLY a JSON object (no markdown, no explanations) with this exact structure: " +
                        "{\"hotel_name\": \"realistic hotel name\", " +
                        "\"city_area\": \"specific area or neighborhood in %s\", " +
                        "\"nightly_rate_sar\": realistic_price_number_in_SAR, " +
                        "\"nights\": 5}",
                city, city
        );

        try {
            String aiResponse = callGemini(prompt);
            return parseHotelResponse(aiResponse);
        } catch (Exception e) {
            try {
                Thread.sleep(2000);
                String aiResponse = callGemini(prompt);
                return parseHotelResponse(aiResponse);
            } catch (Exception retry) {
                System.out.println("AI Hotel error after retry: " + retry.getMessage());
                return fallbackHotel(city);
            }
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

    private ExternalHotelResponse parseHotelResponse(String aiResponse) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(aiResponse);
        String content = root.get("candidates").get(0)
                .get("content").get("parts").get(0)
                .get("text").asText();

        content = content.replaceAll("```json", "").replaceAll("```", "").trim();

        return mapper.readValue(content, ExternalHotelResponse.class);
    }

    private ExternalHotelResponse fallbackHotel(String city) {
        return new ExternalHotelResponse("Grand Hotel", city, 500.0, 5);
    }
}