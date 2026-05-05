package fcit.cpit252.Ertehal.Adapter_response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalActivityResponse {

    @JsonProperty("place_name")
    private String placeName;

    @JsonProperty("city")
    private String city;

    @JsonProperty("category")
    private String category;

    public ExternalActivityResponse() {}

    public ExternalActivityResponse(String placeName, String city, String category) {
        this.placeName = placeName;
        this.city = city;
        this.category = category;
    }

    public String getPlaceName() { return placeName; }
    public String getCity() { return city; }
    public String getCategory() { return category; }
}