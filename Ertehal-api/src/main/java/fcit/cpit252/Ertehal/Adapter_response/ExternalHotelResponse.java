package fcit.cpit252.Ertehal.Adapter_response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalHotelResponse {

    @JsonProperty("property_name")
    private String propertyName;

    @JsonProperty("city_name")
    private String cityName;

    @JsonProperty("rate_total_amount")
    private String rateTotalAmount;

    @JsonProperty("number_of_nights")
    private int numberOfNights;

    public ExternalHotelResponse() {}

    public ExternalHotelResponse(String propertyName, String cityName,
                                 String rateTotalAmount, int numberOfNights) {
        this.propertyName = propertyName;
        this.cityName = cityName;
        this.rateTotalAmount = rateTotalAmount;
        this.numberOfNights = numberOfNights;
    }

    public String getPropertyName() { return propertyName; }
    public String getCityName() { return cityName; }
    public String getRateTotalAmount() { return rateTotalAmount; }
    public int getNumberOfNights() { return numberOfNights; }
}