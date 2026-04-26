package fcit.cpit252.Ertehal;

public class ExternalFlightResponse {
    private final String origin;
    private final String destination;
    private final double fare;

    public ExternalFlightResponse(String origin, String destination, double fare) {
        this.origin = origin;
        this.destination = destination;
        this.fare = fare;
    }

    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public double getFare() { return fare; }
}
