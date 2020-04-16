package earth.bermuda.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProductOfArrayExceptSelfTest {

    @Test
    public void can_calculate_product_1() {
        int[] target = new int[]{1, 2, 3, 4};
        int[] expected = new int[]{24, 12, 8, 6};
        int[] actual = new ProductOfArrayExceptSelf().productExceptSelf(target);
        assertArrayEquals(expected, actual, Arrays.toString(target));
    }

    public static int[] validate(int[] nums) {
        long sum = 1l;
        for (int num : nums) {
            sum *= num;
        }
        if (sum > (long) Integer.MAX_VALUE) {
            throw new RuntimeException("An unexpected overflow has occured");
        }
        int sum_i = (int) sum;
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            output[i] = sum_i / nums[i];
        }
        return output;
    }

    @Test
    public void can_run_10_000() {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
        for (int i = 0; i < 10_000; i++) {
            long non_zero_product = 1;
            int[] target = new int[(int) (Math.random() * 100)];
            for (int j = 0; j < target.length; j++) {
                int candidate = (int) (Math.random() * Math.min(100, (int) ((long) Integer.MAX_VALUE / Math.abs(non_zero_product))));
                target[j] = candidate * (Math.random() < .1 ? -1 : 1);
            }
            int[] expected = validate(Arrays.copyOf(target, target.length));
            int[] actual = solution.productExceptSelf(Arrays.copyOf(target, target.length));
            assertArrayEquals(expected, actual, Arrays.toString(target));
        }
    }
}