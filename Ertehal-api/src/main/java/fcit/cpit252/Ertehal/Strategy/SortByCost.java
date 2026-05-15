package fcit.cpit252.Ertehal.Strategy;

import fcit.cpit252.Ertehal.Model.TravelComponent;
import org.springframework.stereotype.Component;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component("sortByCost")
public class SortByCost implements SortStrategy {

    @Override
    public List<TravelComponent> sort(List<TravelComponent> components) {
        return components.stream()
                .sorted(Comparator.comparingDouble(TravelComponent::getCost))
                .collect(Collectors.toList());
    }

    @Override
    public String getName() {
        return "Sorted by Cost (cheapest first)";
    }
}