import java.util.*;
import java.util.concurrent.*;

/**
 * Demonstrates the concept of Fail-Safe Iterators using ConcurrentHashMap.
 * 
 * In Java, when you iterate over a collection and modify it at the same time,
 * normally (like with HashMap, ArrayList), it throws
 * ConcurrentModificationException because they are fail-fast.
 * 
 * However, ConcurrentHashMap provides a fail-safe iterator. This means
 * iteration is done on a "snapshot" of the collection at the time of iteration,
 * and modifications (like put, remove) do not cause exceptions.
 * 
 * NOTE: Modifications may or may not be visible immediately during iteration,
 * but iteration itself remains safe without throwing errors.
 */
public class FailSafeExample {

    public static void main(String[] args) {
        // Using ConcurrentHashMap (fail-safe) instead of HashMap (fail-fast)
        Map<Integer, String> map = new ConcurrentHashMap<>();

        // Adding some key-value pairs
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        // Obtaining an Iterator on the keySet of the map
        Iterator<Integer> it = map.keySet().iterator();

        // Iterating over the map while modifying it
        while (it.hasNext()) {
            Integer key = it.next();

            // Printing current key and value
            System.out.println(key + " -> " + map.get(key));

            // Modifying the map while iterating (adding new entry)
            // This will NOT throw ConcurrentModificationException
            // because ConcurrentHashMap is fail-safe
            map.put(4, "D");
        }

        // Printing final map contents after iteration
        System.out.println("Final Map: " + map);
    }
}

