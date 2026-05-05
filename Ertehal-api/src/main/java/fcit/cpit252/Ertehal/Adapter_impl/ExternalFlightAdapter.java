package fcit.cpit252.Ertehal.Adapter_impl;

import fcit.cpit252.Ertehal.Adapter.FlightAdapter;
import fcit.cpit252.Ertehal.Adapter_response.ExternalFlightResponse;
import fcit.cpit252.Ertehal.Model.Flight;

public class ExternalFlightAdapter implements FlightAdapter {

    @Override
    public Flight adapt(ExternalFlightResponse response) {
        String origin = response.getOriginIata() != null
                ? response.getOriginIata() : "UNKNOWN";

        String destination = response.getDestinationIata() != null
                ? response.getDestinationIata() : "UNKNOWN";

        double price = parseAmount(response.getTotalAmount(), 1500.0);

        return new Flight(origin, destination, price);
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