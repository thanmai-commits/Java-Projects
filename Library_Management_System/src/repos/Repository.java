package repos;

import java.util.Collection;
import java.util.Optional;

public interface Repository <T, k>{
    void save(T item);
    Optional<T> findById(k id);
    Collection<T> findAll();
    void deleteById(k id);
    int size();

}
