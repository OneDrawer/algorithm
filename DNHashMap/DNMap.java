package Hashmap;

/**
 * Created by xwz on 1/11/17.
 */
public interface DNMap<K, V> {

    V put(K key, V value);
    V get(K key);

    int size();

    interface Entry<K, V> {
        K getkey();
        V getValue();
    }
}
