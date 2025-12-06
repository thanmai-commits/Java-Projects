package repos;

import java.util.Collection;
import java.util.Optional;

public interface Repository <T, K>{
    void save(T item);
    void printKey(T item);
    Optional<T> findById(K id);
    Collection<T> findAll();
    void deleteById(K id);
    int size();

}
