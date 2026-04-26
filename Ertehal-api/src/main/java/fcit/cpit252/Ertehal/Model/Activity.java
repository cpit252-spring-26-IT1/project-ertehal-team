package fcit.cpit252.Ertehal.Model;

public class Activity implements TravelComponent {
    private String name;
    private String location;
    private double cost;

    public Activity(String name, String location, double cost) {
        this.name = name;
        this.location = location;
        this.cost = cost;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String getSummary() {
        return "Activity: " + name + " in " + location + " — " + cost + " SAR";
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

}
