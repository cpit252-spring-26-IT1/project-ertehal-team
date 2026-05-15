package fcit.cpit252.Ertehal.Strategy;

import fcit.cpit252.Ertehal.Model.TravelComponent;
import java.util.List;

public interface SortStrategy {
    List<TravelComponent> sort(List<TravelComponent> components);
    String getName();
}