package fcit.cpit252.Ertehal.Service;

import fcit.cpit252.Ertehal.Adapter.ActivityAdapter;
import fcit.cpit252.Ertehal.Adapter.FlightAdapter;
import fcit.cpit252.Ertehal.Adapter.HotelAdapter;
import fcit.cpit252.Ertehal.Adapter_response.ExternalActivityResponse;
import fcit.cpit252.Ertehal.Adapter_response.ExternalFlightResponse;
import fcit.cpit252.Ertehal.Adapter_response.ExternalHotelResponse;
import fcit.cpit252.Ertehal.Model.Itinerary;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItineraryService {

    private final ApiService<ExternalFlightResponse> flightApi;
    private final ApiService<ExternalHotelResponse> hotelApi;
    private final ApiCollectionService<ExternalActivityResponse> activityApi;
    private final FlightAdapter flightAdapter;
    private final HotelAdapter hotelAdapter;
    private final ActivityAdapter activityAdapter;

    public ItineraryService(
            @Qualifier("flightApiService") ApiService<ExternalFlightResponse> flightApi,
            @Qualifier("hotelApiService") ApiService<ExternalHotelResponse> hotelApi,
            @Qualifier("activityApiService") ApiCollectionService<ExternalActivityResponse> activityApi,
            FlightAdapter flightAdapter,
            HotelAdapter hotelAdapter,
            ActivityAdapter activityAdapter) {
        this.flightApi = flightApi;
        this.hotelApi = hotelApi;
        this.activityApi = activityApi;
        this.flightAdapter = flightAdapter;
        this.hotelAdapter = hotelAdapter;
        this.activityAdapter = activityAdapter;
    }

    public Itinerary buildItinerary(String tripName, String country, int activityCount) {
        Itinerary.Builder builder = new Itinerary.Builder(tripName);

        // Add one flight
        builder.addFlight(flightAdapter.adapt(flightApi.fetch(country)));

        // Add one hotel
        builder.addHotel(hotelAdapter.adapt(hotelApi.fetch(country)));

        // Add multiple activities
        List<ExternalActivityResponse> activities = activityApi.fetch(country, activityCount);
        for (ExternalActivityResponse activity : activities) {
            builder.addActivity(activityAdapter.adapt(activity));
        }

        return builder.build();
    }
}