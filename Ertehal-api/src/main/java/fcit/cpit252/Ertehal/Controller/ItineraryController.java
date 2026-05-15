package fcit.cpit252.Ertehal.Controller;

import fcit.cpit252.Ertehal.Model.Itinerary;
import fcit.cpit252.Ertehal.Service.ItineraryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/itinerary")
public class ItineraryController {

    private final ItineraryService itineraryService;

    public ItineraryController(ItineraryService itineraryService) {
        this.itineraryService = itineraryService;
    }

    @GetMapping("/demo")
    public String demo() {
        Itinerary itinerary = itineraryService.buildItinerary("Summer Vacation", "france", 3);
        return itinerary.getSummary();
    }

    @GetMapping("/build")
    public String build(
            @RequestParam(defaultValue = "My Trip") String tripName,
            @RequestParam(defaultValue = "france") String country,
            @RequestParam(defaultValue = "3") int activities) {

        // Clamp activities between 1 and 5
        int activityCount = Math.max(1, Math.min(activities, 5));

        Itinerary itinerary = itineraryService.buildItinerary(tripName, country, activityCount);
        return itinerary.getSummary();
    }
}