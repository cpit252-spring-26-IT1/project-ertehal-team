package fcit.cpit252.Ertehal.Adapter_impl;

import fcit.cpit252.Ertehal.Adapter.HotelAdapter;
import fcit.cpit252.Ertehal.Adapter_response.ExternalHotelResponse;
import fcit.cpit252.Ertehal.Model.Hotel;

public class AIHotelAdapter implements HotelAdapter {

    @Override
    public Hotel adapt(ExternalHotelResponse response) {
        String name = (response.getHotelName() != null && !response.getHotelName().isEmpty())
                ? response.getHotelName()
                : "Grand Hotel";

        String location = (response.getCityArea() != null && !response.getCityArea().isEmpty())
                ? response.getCityArea()
                : "City Center";

        double nightlyRate = response.getNightlyRateSar() > 0
                ? response.getNightlyRateSar()
                : 500.0;

        int nights = response.getNights() > 0 ? response.getNights() : 5;

        return new Hotel(name, location, nightlyRate, nights);
    }
}