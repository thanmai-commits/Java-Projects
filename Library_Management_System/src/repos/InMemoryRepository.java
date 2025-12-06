package repos;

import java.util.*;
import java.util.function.Function;

public class InMemoryRepository<T, K> implements Repository<T, K> {
    /**
     * k is key type
     * T is entity type
     */
    // Internal Storage ==> LinkedHashMap makes sure that the object has the key value pair and also objects are sorted in the order as they were added.
    private final Map<K, T> storage = new LinkedHashMap<>();
    //To extract a key from an entity
    private final Function<T, K> keyExtractor;
    public InMemoryRepository(Function<T, K> keyExtractor) {
        this.keyExtractor = Objects.requireNonNull(keyExtractor, "keyExtractor must not be null");
    }
    @Override
    public void save(T item){
        Objects.requireNonNull(item);
        K key = Objects.requireNonNull(keyExtractor.apply(item), "extracted key cannot be null (check keyExtractor or item)");
        storage.put(key, item);
    }
    //Optional method to print key.
    @Override
    public void printKey(T item){
        K key = Objects.requireNonNull(keyExtractor.apply(item), "extracted key cannot be null (check keyExtractor or item)");
        System.out.println(key);
    }
    @Override
    public Optional<T> findById(K id){
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public Collection<T> findAll(){
        return new ArrayList<>(storage.values());
    }
    @Override
    public synchronized void deleteById(K id) {
        storage.remove(id);
    }

    @Override
    public synchronized int size() {
        return storage.size();
    }


}
