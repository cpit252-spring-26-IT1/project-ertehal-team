package sa.edu.kau.fcit.cpit252.Ertehal;

public class User {
    private String userId;

    public User(String userId) {
        this.userId = userId;
    }

    public void buildTrip() {
        ItineraryBuilder builder = new ItineraryBuilder("Summer Vacation");
        Itinerary myTrip = builder.addFlight(new Flight("JED", "PAR", 1500.0))
                .addHotel(new Hotel("Ritz", 500.0, 5))
                .addActivity(new Activity("Eiffel Tower", "Paris", 100.0))
                .build();

        System.out.println(myTrip.getSummary());
    }

    public String getUserId() {
        return userId;
    }
}
