package fcit.cpit252.Ertehal.Adapter_response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalHotelResponse {

    @JsonProperty("hotel_name")
    private String hotelName;

    @JsonProperty("city_area")
    private String cityArea;

    @JsonProperty("nightly_rate_sar")
    private double nightlyRateSar;

    @JsonProperty("nights")
    private int nights;

    public ExternalHotelResponse() {}

    public ExternalHotelResponse(String hotelName, String cityArea, double nightlyRateSar, int nights) {
        this.hotelName = hotelName;
        this.cityArea = cityArea;
        this.nightlyRateSar = nightlyRateSar;
        this.nights = nights;
    }

    public String getHotelName() { return hotelName; }
    public String getCityArea() { return cityArea; }
    public double getNightlyRateSar() { return nightlyRateSar; }
    public int getNights() { return nights; }
}