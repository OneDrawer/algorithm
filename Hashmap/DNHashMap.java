package Hashmap;

/**
 * Created by xwz on 1/11/17.
 */
public class DNHashMap<K,V> implements DNMap<K,V> {

    private static Integer defaultLength = 16;
    private static double defaultLoad = 0.75;
    private Entry<K,V>[] table = null;
    //size记录数组元素的个数的
    private int size = 0;

    DNHashMap(int defaultLength, double defaultLoad) {
        this.defaultLength = defaultLength;
        this.defaultLoad = defaultLoad;
        this.table = new Entry[defaultLength];
    }

    DNHashMap() {
        this(defaultLength, defaultLoad);
    }
    @Override
    public V put(K key, V value) {
        //根据key和哈希函数getIndex()取得index
        int index = this.getIndex(key);
        Entry<K,V> e = table[index];
        if(e == null) {
            table[index] = new Entry(key, value, null, index);
            size++;
        } else {
            Entry newEntry = new Entry(key, value, e, index);
            table[index] = newEntry;
        }
        return table[index].getValue();
    }

    public int getIndex(K key) {
        int m = this.defaultLength - 1;
        return key.hashCode() % m;
    }
    @Override
    public V get(K key) {
        //根据key和哈希函数得到下标
        int index = this.getIndex(key);

        return table[index] == null ? null : table[index].getValue();
    }

    @Override
    public int size() {
        return size;
    }

    class Entry<K, V> implements DNMap.Entry<K, V> {
        K key;
        V value;
        Entry<K,V> next;
        int index;

        Entry(K key, V value, Entry<K,V> n, int inx) {
            this.key = key;
            this.value = value;
            this.next = n;
            this.index = inx;
        }

        @Override
        public K getkey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }
}
