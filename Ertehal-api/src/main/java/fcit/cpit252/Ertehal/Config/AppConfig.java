package fcit.cpit252.Ertehal.Config;

import fcit.cpit252.Ertehal.Adapter.ActivityAdapter;
import fcit.cpit252.Ertehal.Adapter.FlightAdapter;
import fcit.cpit252.Ertehal.Adapter.HotelAdapter;
import fcit.cpit252.Ertehal.Adapter_impl.ExternalActivityAdapter;
import fcit.cpit252.Ertehal.Adapter_impl.ExternalFlightAdapter;
import fcit.cpit252.Ertehal.Adapter_impl.ExternalHotelAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public FlightAdapter flightAdapter() {
        return new ExternalFlightAdapter();
    }

    @Bean
    public HotelAdapter hotelAdapter() {
        return new ExternalHotelAdapter();
    }

    @Bean
    public ActivityAdapter activityAdapter() {
        return new ExternalActivityAdapter();
    }
}