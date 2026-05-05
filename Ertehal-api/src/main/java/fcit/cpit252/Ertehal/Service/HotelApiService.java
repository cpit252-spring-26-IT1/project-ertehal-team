package fcit.cpit252.Ertehal.Service;

import fcit.cpit252.Ertehal.Adapter_response.ExternalHotelResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("hotelApiService")
public class HotelApiService implements ApiService<ExternalHotelResponse> {

    @Value("${duffel.api.key}")
    private String apiKey;

    @Override
    public ExternalHotelResponse fetch() {
        // Duffel Stays requires a POST request with check-in/out dates
        // and location. For the demo, we return realistic sample data
        // that matches Duffel Stays field format.
        // The Adapter translates between:
        // - ExternalHotelResponse (propertyName, cityName, rateTotalAmount)
        // - Hotel model (name, location, nightlyRate, nights)

        return new ExternalHotelResponse(
                "Le Grand Paris", "Paris", "2500.00", 5
        );
    }
}