package earth.bermuda.leetcode.contest1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MinimumValueToGetPositiveStepByStepSumTest {

    @Test
    public void testCase1() {
        int[] nums = new int[]{1, 2};
        int expected = 1;
        int actual = new MinimumValueToGetPositiveStepByStepSum().minStartValue(nums);
        assertEquals(expected, actual, Arrays.toString(nums));
    }


    @Test
    public void testCase2() {
        int[] nums = new int[]{-3, 2, -3, 4, 2};
        int expected = 5;
        int actual = new MinimumValueToGetPositiveStepByStepSum().minStartValue(nums);
        assertEquals(expected, actual, Arrays.toString(nums));
    }

    @Test
    public void testCase3() {
        int[] nums = new int[]{1, -2, -3};
        int expected = 5;
        int actual = new MinimumValueToGetPositiveStepByStepSum().minStartValue(nums);
        assertEquals(expected, actual, Arrays.toString(nums));
    }
}