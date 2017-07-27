package Hashmap;

/**
 * Created by xwz on 3/13/17.
 */
public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap<String, String> mm = new MyHashMap<String, String>();
        Long aBeginTime=System.currentTimeMillis();//记录BeginTime
        for(int i=0;i<10000000;i++){
            mm.put(""+i, ""+i*100);
        }
        Long aEndTime=System.currentTimeMillis();//记录EndTime
        System.out.println("insert time-->"+(aEndTime-aBeginTime) + "ms");

        Long lBeginTime=System.currentTimeMillis();//记录BeginTime
        mm.get(""+100000);
        Long lEndTime=System.currentTimeMillis();//记录EndTime
        System.out.println("seach time--->"+(lEndTime-lBeginTime));
    }
}
