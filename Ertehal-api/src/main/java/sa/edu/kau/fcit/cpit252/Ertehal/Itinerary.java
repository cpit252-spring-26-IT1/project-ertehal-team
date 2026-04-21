package sa.edu.kau.fcit.cpit252.Ertehal;

public class Itinerary {

    private String tripName;
    private HashMap<String, TravelComponent> components;

    public Itinerary(String tripName) {
        this.tripName = tripName;
        this.components = new HashMap<>();
    }

    public void addComponent(String key, TravelComponent component) {
        components.put(key, component);
    }

    public double getTotalCost() {
        double total = 0;
        for (TravelComponent c : components.values()) {
            total += c.getCost();
        }
        return total;
    }

    public String getSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("Trip: ").append(tripName).append("\n");
        for (Map.Entry<String, TravelComponent> entry : components.entrySet()) {
            sb.append("  [").append(entry.getKey()).append("] ");
            sb.append(entry.getValue().getSummary()).append("\n");
        }
        sb.append("Total Cost: ").append(getTotalCost()).append(" SAR");
        return sb.toString();
    }

    public HashMap<String, TravelComponent> getComponents() {
        return components;
    }

    public String getTripName() {
        return tripName;
    }


}



