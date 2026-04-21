package sa.edu.kau.fcit.cpit252.Ertehal;

public class ItineraryBuilder {
    private Itinerary itinerary;

    public ItineraryBuilder(String tripName) {
        this.itinerary = new Itinerary(tripName);
    }

    public ItineraryBuilder addFlight(Flight f) {
        itinerary.addComponent("Flight to " + f.getDestination(), f);
        return this;
    }

    public ItineraryBuilder addHotel(Hotel h) {
        itinerary.addComponent("Hotel " + h.getName(), h);
        return this;
    }

    public ItineraryBuilder addActivity(Activity a) {
        itinerary.addComponent("Activity " + a.getName(), a);
        return this;
    }

    public Itinerary build() {
        return this.itinerary;
    }
}

