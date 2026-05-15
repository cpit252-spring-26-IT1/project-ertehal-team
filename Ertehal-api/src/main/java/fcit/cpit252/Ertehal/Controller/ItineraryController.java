package fcit.cpit252.Ertehal.Controller;

import fcit.cpit252.Ertehal.Model.Itinerary;
import fcit.cpit252.Ertehal.Service.ItineraryService;
import fcit.cpit252.Ertehal.Strategy.SortStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/itinerary")
public class ItineraryController {

    private final ItineraryService itineraryService;
    private final SortStrategy sortByCost;
    private final SortStrategy sortByCostDescending;
    private final SortStrategy sortByType;

    public ItineraryController(
            ItineraryService itineraryService,
            @Qualifier("sortByCost") SortStrategy sortByCost,
            @Qualifier("sortByCostDescending") SortStrategy sortByCostDescending,
            @Qualifier("sortByType") SortStrategy sortByType) {
        this.itineraryService = itineraryService;
        this.sortByCost = sortByCost;
        this.sortByCostDescending = sortByCostDescending;
        this.sortByType = sortByType;
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
            @RequestParam(defaultValue = "3") int activities,
            @RequestParam(defaultValue = "default") String sortBy) {

        int activityCount = Math.max(1, Math.min(activities, 5));
        Itinerary itinerary = itineraryService.buildItinerary(tripName, country, activityCount);

        SortStrategy strategy = switch (sortBy.toLowerCase()) {
            case "cost" -> sortByCost;
            case "cost-desc" -> sortByCostDescending;
            case "type" -> sortByType;
            default -> null;
        };

        if (strategy == null) {
            return itinerary.getSummary();
        }
        return itinerary.getSummarySorted(strategy);
    }
}