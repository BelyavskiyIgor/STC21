import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class MyHashMapTest {

    @Test
    public void put() {
        MyHashMap myMap = new MyHashMap();
        HashMap map = new HashMap();
        for(int i =0; i < 5; i++){

            Assert.assertEquals(map.put(i, i), myMap.put(i, i));

        }

    }
}