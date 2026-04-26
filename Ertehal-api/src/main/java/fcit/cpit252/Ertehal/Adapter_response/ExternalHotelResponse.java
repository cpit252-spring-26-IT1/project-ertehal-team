package fcit.cpit252.Ertehal.Adapter_response;

public class ExternalHotelResponse {
    private final String propertyName;
    private final String city;
    private final double ratePerNight;
    private final int numberOfNights;

    public ExternalHotelResponse(String propertyName, String city,
                                 double ratePerNight, int numberOfNights) {
        this.propertyName = propertyName;
        this.city = city;
        this.ratePerNight = ratePerNight;
        this.numberOfNights = numberOfNights;
    }

    public String getPropertyName() { return propertyName; }
    public String getCity() { return city; }
    public double getRatePerNight() { return ratePerNight; }
    public int getNumberOfNights() { return numberOfNights;}
}
