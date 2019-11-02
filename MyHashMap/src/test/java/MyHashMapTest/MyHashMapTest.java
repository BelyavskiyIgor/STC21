package MyHashMapTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


public class MyHashMapTest {


    MyHashMap map = new MyHashMap();

    @Test
    public void put() {
        map.put(1, "ABC");
        map.put(1, "AAA");

        map.put(2, "BBB");
        map.put(3, "CCC");

        Assert.assertEquals("AAA", map.getValue(1));
        Assert.assertEquals("BBB", map.getValue(2));
        Assert.assertEquals("CCC", map.getValue(3));
        Assert.assertEquals(3, map.getSize());
    }

    @Test
    public void remove() {
        map.put(1, "ABC");
       // map.put(1, "AAA");
        Assert.assertEquals(1,map.getSize());
        map.remove(1);
        Assert.assertEquals(0,map.getSize());
        Assert.assertNull(map.getValue(1));
    }
}
