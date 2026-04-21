package sa.edu.kau.fcit.cpit252.Ertehal;

public class Hotel implements TravelComponent {
    private String name;
    private double nightlyRate;
    private int nights;

    public Hotel(String name, double nightlyRate, int nights) {
        this.name = name;
        this.nightlyRate = nightlyRate;
        this.nights = nights;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNightlyRate() {
        return nightlyRate;
    }

    public void setNightlyRate(double nightlyRate) {
        this.nightlyRate = nightlyRate;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    @Override
    public double getCost() {
        return nightlyRate * nights;
    }
}
