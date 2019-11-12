import org.junit.Assert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GenericAppTest {
    Map map = new HashMap<Integer, Integer>();
    GenericApp mymap = new GenericApp();

    @org.junit.jupiter.api.Test
    void size() {
        Assert.assertEquals(map.size(), mymap.size());
    }

    @org.junit.jupiter.api.Test
    void put() {
        map.put(1, 123);
        map.put(2, 222);



        Assert.assertEquals(123, map.get(1));
        Assert.assertEquals(222, map.get(2));

    }


}