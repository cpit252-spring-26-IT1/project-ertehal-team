package fcit.cpit252.Ertehal.Adapter_response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalFlightResponse {

    @JsonProperty("origin_iata")
    private String originIata;

    @JsonProperty("destination_iata")
    private String destinationIata;

    @JsonProperty("total_amount")
    private String totalAmount;

    @JsonProperty("total_currency")
    private String totalCurrency;

    public ExternalFlightResponse() {}

    public ExternalFlightResponse(String originIata, String destinationIata,
                                  String totalAmount, String totalCurrency) {
        this.originIata = originIata;
        this.destinationIata = destinationIata;
        this.totalAmount = totalAmount;
        this.totalCurrency = totalCurrency;
    }

    public String getOriginIata() { return originIata; }
    public String getDestinationIata() { return destinationIata; }
    public String getTotalAmount() { return totalAmount; }
    public String getTotalCurrency() { return totalCurrency; }
}