package fcit.cpit252.Ertehal.Adapter_impl;

import fcit.cpit252.Ertehal.Adapter.HotelAdapter;
import fcit.cpit252.Ertehal.Adapter_response.ExternalHotelResponse;
import fcit.cpit252.Ertehal.Model.Hotel;

public class ExternalHotelAdapter implements HotelAdapter {

    @Override
    public Hotel adapt(ExternalHotelResponse response) {
        String name = response.getPropertyName() != null
                ? response.getPropertyName() : "Unknown Hotel";

        String location = response.getCityName() != null
                ? response.getCityName() : "Unknown City";

        int nights = response.getNumberOfNights() > 0
                ? response.getNumberOfNights() : 1;

        double total = parseAmount(response.getRateTotalAmount(), 500.0);
        double nightlyRate = total / nights;

        return new Hotel(name, location, nightlyRate, nights);
    }

    private double parseAmount(String amount, double fallback) {
        if (amount == null) return fallback;
        try {
            return Double.parseDouble(amount);
        } catch (NumberFormatException e) {
            return fallback;
        }
    }
}