package earth.bermuda.leetcode.april;

import earth.bermuda.leetcode.april.MaximumSubArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by james on 03/04/2020.
 */
public class MaximumSubArrayTest {
    @Test
    public void test_can_find_1() {
        int result = new MaximumSubArray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        int expected = 6;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_can_find_2() {
        int result = new MaximumSubArray().maxSubArray(new int[]{2, -1, 3, -4, 1, -2, -1, 5, -4});
        int expected = 5;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_can_find_3() {
        int result = new MaximumSubArray().maxSubArray(new int[]{-2, -1, -3, -4, -1, -2, -1, -5, -4});
        int expected = -1;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_can_find_4() {
        int result = new MaximumSubArray().maxSubArray(new int[]{-2});
        int expected = -2;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_can_find_5() {
        int result = new MaximumSubArray().maxSubArray(new int[]{Integer.MIN_VALUE});
        int expected = Integer.MIN_VALUE;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_can_find_6() {
        int result = new MaximumSubArray().maxSubArray(new int[]{1, 2});
        int expected = 3;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_can_find_7() {
        int result = new MaximumSubArray().maxSubArray(new int[]{9, 0, -2, -2, -3, -4, 0, 1, -4, 5, -8, 7, -3, 7, -6, -4, -7, -8});
        ;
        int expected = 11;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_can_find_100000_tests() {
        for (int x = 0; x < 100000; x++) {
            int[] target = new int[(int) (Math.random() * 10) + 1];
            for (int i = 0; i < target.length; i++) {
                target[i] = (int) (Math.random() * 100 - 50);
            }
            MaximumSubArray msa = new MaximumSubArray();
            int result = msa.maxSubArray(target);
            int expected = msa.validate(target);
            Assertions.assertTrue(result == expected);
        }
    }


}
