package fcit.cpit252.Ertehal.Model;

public class Flight implements TravelComponent {
    private String origin;
    private String destination;
    private double price;

    public Flight(String origin, String destination, double price) {
        this.origin = origin;
        this.destination = destination;
        this.price = price;
    }

    @Override
    public double getCost() {
        return price;
    }

    @Override
    public String getSummary() {
        return "Flight: " + origin + " → " + destination + " — " + price + " SAR";
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public double getPrice() {
        return price;
    }
}
