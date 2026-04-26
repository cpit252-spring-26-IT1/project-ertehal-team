package fcit.cpit252.Ertehal.Model;

import java.util.HashMap;
import java.util.Map;

public class Itinerary {
    private final String tripName;
    private final HashMap<String, TravelComponent> components;

    private Itinerary(Builder builder) {
        this.tripName = builder.tripName;
        this.components = builder.components;
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

    public String getTripName() {
        return tripName;
    }

    public HashMap<String, TravelComponent> getComponents() {
        return components;
    }

    // Nested Builder
    public static class Builder {

        private final String tripName;
        private final HashMap<String, TravelComponent> components = new HashMap<>();
        private int flightCount = 0;
        private int hotelCount = 0;
        private int activityCount = 0;

        public Builder(String tripName) {
            this.tripName = tripName;
        }

        public Builder addFlight(Flight flight) {
            flightCount++;
            components.put("flight_" + flightCount, flight);
            return this;
        }

        public Builder addHotel(Hotel hotel) {
            hotelCount++;
            components.put("hotel_" + hotelCount, hotel);
            return this;
        }

        public Builder addActivity(Activity activity) {
            activityCount++;
            components.put("activity_" + activityCount, activity);
            return this;
        }

        public Itinerary build() {
            return new Itinerary(this);
        }
    }
}
