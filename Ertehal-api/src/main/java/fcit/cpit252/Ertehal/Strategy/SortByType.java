package fcit.cpit252.Ertehal.Strategy;

import fcit.cpit252.Ertehal.Model.Activity;
import fcit.cpit252.Ertehal.Model.Flight;
import fcit.cpit252.Ertehal.Model.Hotel;
import fcit.cpit252.Ertehal.Model.TravelComponent;
import org.springframework.stereotype.Component;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component("sortByType")
public class SortByType implements SortStrategy {

    @Override
    public List<TravelComponent> sort(List<TravelComponent> components) {
        return components.stream()
                .sorted(Comparator.comparingInt(this::typeOrder))
                .collect(Collectors.toList());
    }

    private int typeOrder(TravelComponent c) {
        if (c instanceof Flight) return 1;
        if (c instanceof Hotel) return 2;
        if (c instanceof Activity) return 3;
        return 4;
    }

    @Override
    public String getName() {
        return "Sorted by Type (flights, then hotels, then activities)";
    }
}