package fcit.cpit252.Ertehal.Adapter;
import fcit.cpit252.Ertehal.Adapter_response.ExternalFlightResponse;
import fcit.cpit252.Ertehal.Model.Flight;

public interface FlightAdapter {
    Flight adapt(ExternalFlightResponse response);
}
