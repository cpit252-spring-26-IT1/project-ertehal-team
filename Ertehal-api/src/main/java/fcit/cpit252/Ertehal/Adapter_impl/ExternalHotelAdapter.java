package fcit.cpit252.Ertehal.Adapter_impl;

import fcit.cpit252.Ertehal.Adapter_response.ExternalHotelResponse;
import fcit.cpit252.Ertehal.Model.Hotel;
import fcit.cpit252.Ertehal.Adapter.HotelAdapter;

public class ExternalHotelAdapter implements HotelAdapter {

    @Override
    public Hotel adapt(ExternalHotelResponse response) {
        return new Hotel(
                response.getPropertyName(),
                response.getCity(),
                response.getRatePerNight(),
                response.getNumberOfNights());
    }
}