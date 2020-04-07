package earth.bermuda.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CountingElementsTest {

    @Test
    public void canCountElements1() {
        int[] target = new int[] {1,2,3};
        int expected = 2;
        int actual = new CountingElements().countElements(target);
        assertEquals(expected, actual, Arrays.toString(target));
    }

    @Test
    public void canCountElements2() {
        int[] target = new int[] {1,1,3,3,5,5,7,7};
        int expected = 0;
        int actual = new CountingElements().countElements(target);
        assertEquals(expected, actual, Arrays.toString(target));
    }

    @Test
    public void canCountElements3() {
        int[] target = new int[] {1,3,2,3,5,0};
        int expected = 3;
        int actual = new CountingElements().countElements(target);
        assertEquals(expected, actual, Arrays.toString(target));
    }

    @Test
    public void canCountElements4() {
        int[] target = new int[] {1,1,2,2};
        int expected = 2;
        int actual = new CountingElements().countElements(target);
        assertEquals(expected, actual, Arrays.toString(target));
    }
}