package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new ConcurrentHashMap<>();
    //private static long sequence = 0L;
    private static AtomicLong sequence = new AtomicLong(0);

    public Item save(Item item) {
        //item.setId(++sequence);
        store.put(sequence.incrementAndGet(), item);
        return item;
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }


}
