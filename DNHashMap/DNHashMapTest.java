package Hashmap;

/**
 * Created by xwz on 1/11/17.
 */
public class DNHashMapTest {
    public static void main(String[] args) {
        DNHashMap map = new DNHashMap();
        map.put("xwz", "handsome boy");
        map.put("syx", "beautifule girl");

        System.out.println("xwz:" + map.get("xwz"));
        System.out.println("syx:" + map.get("syx"));
    }
}
