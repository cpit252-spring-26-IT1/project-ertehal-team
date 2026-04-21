package sa.edu.kau.fcit.cpit252.Ertehal;

public class Activity implements TravelComponent {
    private String name;
    private String location;
    private double cost;

    public Activity(String name, String location, double cost) {
        this.name = name;
        this.location = location;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public double getCost() {
        return cost;
    }
}
