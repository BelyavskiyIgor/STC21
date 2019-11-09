import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ProxyMechanismsTest {

    @Test
    public void cleanup() {
        ClassFields fields = new ClassFields("igor", (byte)1, (short) 2, '3', 4, 5, 6.0f, 7, true);
        Set<String> fieldsToCleanup = new HashSet<>();
        fieldsToCleanup.add("name");
        fieldsToCleanup.add("i");
        fieldsToCleanup.add("ch");
        Set<String> fieldsToOutput = new HashSet<>();
        fieldsToOutput.add("fl");
        fieldsToOutput.add("l");


    }
}