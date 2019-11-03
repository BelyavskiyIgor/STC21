package MyHashMapTest;

import java.util.HashMap;

public class App
{
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        for(int i = 0; i <= 3; i++){
            map.put(i, i);
            map.put(i, i+1);
        }
        System.out.println(map.toString());
        for(int i = 0; i <=3; i++){
            System.out.println(map.getValue(i));
        }

    }


}
