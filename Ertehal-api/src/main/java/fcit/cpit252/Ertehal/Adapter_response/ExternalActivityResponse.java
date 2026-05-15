package fcit.cpit252.Ertehal.Adapter_response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalActivityResponse {

    @JsonProperty("activity_name")
    private String activityName;

    @JsonProperty("city_area")
    private String cityArea;

    @JsonProperty("price_sar")
    private double priceSar;

    public ExternalActivityResponse() {}

    public ExternalActivityResponse(String activityName, String cityArea, double priceSar) {
        this.activityName = activityName;
        this.cityArea = cityArea;
        this.priceSar = priceSar;
    }

    public String getActivityName() { return activityName; }
    public String getCityArea() { return cityArea; }
    public double getPriceSar() { return priceSar; }
}