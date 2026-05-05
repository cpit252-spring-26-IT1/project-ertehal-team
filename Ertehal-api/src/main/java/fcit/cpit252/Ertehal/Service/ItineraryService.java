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

@Service
public class ItineraryService {

    private final ApiService<ExternalFlightResponse> flightApi;
    private final ApiService<ExternalHotelResponse> hotelApi;
    private final ApiService<ExternalActivityResponse> activityApi;
    private final FlightAdapter flightAdapter;
    private final HotelAdapter hotelAdapter;
    private final ActivityAdapter activityAdapter;

    public ItineraryService(
            @Qualifier("flightApiService") ApiService<ExternalFlightResponse> flightApi,
            @Qualifier("hotelApiService") ApiService<ExternalHotelResponse> hotelApi,
            @Qualifier("activityApiService") ApiService<ExternalActivityResponse> activityApi,
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

    public Itinerary buildItinerary(String tripName) {
        return new Itinerary.Builder(tripName)
                .addFlight(flightAdapter.adapt(flightApi.fetch()))
                .addHotel(hotelAdapter.adapt(hotelApi.fetch()))
                .addActivity(activityAdapter.adapt(activityApi.fetch()))
                .build();
    }
}