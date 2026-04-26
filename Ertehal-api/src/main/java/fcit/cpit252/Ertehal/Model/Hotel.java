package fcit.cpit252.Ertehal.Model;

public class Hotel implements TravelComponent {
    private String name;
    private String location;
    private double nightlyRate; // the price of one night
    private int nights; // the number of nights

    public Hotel(String name, String location, double nightlyRate, int nights) {
        this.name = name;
        this.location = location;
        this.nightlyRate = nightlyRate;
        this.nights = nights;
    }

    @Override
    public double getCost() {
        return nightlyRate * nights;
    }

    @Override
    public String getSummary() {
        return "Hotel: " + name + " in " + location +
                " — " + nights + " nights @ " + nightlyRate +
                " SAR/night = " + getCost() + " SAR";
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public double getNightlyRate() {
        return nightlyRate;
    }

    public int getNights() {
        return nights;
    }
}
