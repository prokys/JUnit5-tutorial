package junit5tests;

import listener.Listener;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(Listener.class)
public class AssertionsTest {

    @Test
    void assertEqualsTest(){
        assertEquals("firstString", "secondString", "The string values were not equal");
    }

    @Test
    void assertEqualsListTest(){
        List<String> expectedValues = Arrays.asList("firstString", "secondString", "thirdString");
        List<String> actualValues = Arrays.asList("firstString", "secondString");
        assertEquals(expectedValues, actualValues);
    }

    @Test
    void assertArraysEqualsTest(){
        int[] expectedValues = {1,5,3};
        int[] actualValues = {1,2,3};
        assertArrayEquals(expectedValues, actualValues);
    }

    @Test
    void assertTrueTest(){
        assertFalse(false, "This boolean condition did not evaluate to true");
        assertTrue(false, "This boolean condition did not evaluate to true");
    }

    @Test
    void assertThrowsTest(){
        assertThrows(NullPointerException.class, null);
    }

    @Test
    void assertAllTest(){
        assertAll(
                ()->assertEquals("firstString", "secondString", "The string values were not equal"),
                ()->assertThrows(NullPointerException.class, null),
                ()->assertTrue(false, "This boolean condition did not evaluate to true")
        );
    }

    @Test
    void assertForMapTest(){
        Map<String, Integer> theMap = new HashMap<>();
        theMap.put("firstKey", 1);
        theMap.put("secondKey", 2);
        theMap.put("thirdKey", 3);

        assertThat(theMap, hasValue(2));
        assertThat(theMap, hasKey("secondKey"));
    }

    @Test
    void  assertForList(){
        List<String> theList = Arrays.asList("firstString","secondString", "thirdString");

        assertThat(theList, hasItem("thirdString"));
    }

    @Test
    void  assertAnyOf(){
        List<String> theList = Arrays.asList("firstString","secondString", "thirdString");

        assertThat(theList, anyOf(hasItem("thirdString"), hasItem("noString")));
    }
    @Test
    void  assertForContainsInAnyOrder(){
        List<String> theList = Arrays.asList("firstString","secondString", "thirdString");

        assertThat(theList, containsInAnyOrder("firstString", "thirdString", "secondString"));
    }
}
