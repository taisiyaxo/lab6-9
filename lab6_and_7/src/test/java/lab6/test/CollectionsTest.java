package lab6.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static lab6.CollectionsDemo.filteredBySymbol;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionsTest {
    @Test
    public void filteredBySymbolTest(){
        String s1= new String("red pen");
        String s2= new String("run away");
        String s3= new String("welcome to the club");
        String s4= new String("have a nice day");
        ArrayList<String> strings = new ArrayList<>();
        Collections.addAll(strings, s1, s2, null, s3, s4);
        assertEquals(filteredBySymbol(strings, 'r'), 2);
    }

}
