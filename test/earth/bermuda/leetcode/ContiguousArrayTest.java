package earth.bermuda.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ContiguousArrayTest {

    @Test
    public void can_find_contiguous_array_1() {
        int[] target = new int[] {0,1};
        int expected = 2;
        int actual = new ContiguousArray().findMaxLength(target);
        assertEquals(expected, actual, Arrays.toString(target));
    }

    @Test
    public void can_find_contiguous_array_2() {
        int[] target = new int[] {0,1, 0};
        int expected = 2;
        int actual = new ContiguousArray().findMaxLength(target);
        assertEquals(expected, actual, Arrays.toString(target));
    }

    @Test
    public void can_find_contiguous_array_3() {
        int[] target = new int[] {0,0, 0};
        int expected = 0;
        int actual = new ContiguousArray().findMaxLength(target);
        assertEquals(expected, actual, Arrays.toString(target));
    }

    @Test
    public void can_find_contiguous_array_4() {
        int[] target = new int[] {};
        int expected = 0;
        int actual = new ContiguousArray().findMaxLength(target);
        assertEquals(expected, actual, Arrays.toString(target));
    }

}