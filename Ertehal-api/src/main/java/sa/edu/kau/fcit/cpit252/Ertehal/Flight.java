package sa.edu.kau.fcit.cpit252.Ertehal;

public class Flight implements TravelComponent {
    private String origin;
    // it is the departure city
    private String destination;
    // it is the arrival city
    private double price;

    public Flight(String origin, String destination, double price) {
        this.origin = origin;
        this.destination = destination;
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getCost() {
        return price;
    }
}
