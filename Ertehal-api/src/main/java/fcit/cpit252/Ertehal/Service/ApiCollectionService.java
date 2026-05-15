package fcit.cpit252.Ertehal.Service;

import java.util.List;

public interface ApiCollectionService<T> {
    List<T> fetch(String country, int count);
}