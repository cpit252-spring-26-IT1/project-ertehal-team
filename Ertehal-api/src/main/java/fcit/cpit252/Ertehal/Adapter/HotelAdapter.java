package fcit.cpit252.Ertehal.Adapter;
import fcit.cpit252.Ertehal.Adapter_response.ExternalHotelResponse;
import fcit.cpit252.Ertehal.Model.Hotel;

public interface HotelAdapter {
    Hotel adapt(ExternalHotelResponse response);
}
