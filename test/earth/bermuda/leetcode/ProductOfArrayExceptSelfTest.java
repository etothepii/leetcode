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

    @Test
    public void can_calculate_product_2() {
        int[] target = new int[]{1, 2, 3, 4, 0};
        int[] expected = new int[]{0, 0, 0, 0, 24};
        int[] actual = new ProductOfArrayExceptSelf().productExceptSelf(target);
        assertArrayEquals(expected, actual, Arrays.toString(target));
    }

    @Test
    public void can_calculate_product_3() {
        int[] target = new int[]{1, 2, 3, 4, 0, 0};
        int[] expected = new int[]{0, 0, 0, 0, 0, 0};
        int[] actual = new ProductOfArrayExceptSelf().productExceptSelf(target);
        assertArrayEquals(expected, actual, Arrays.toString(target));
    }

    public static int[] validate(int[] nums) {
        long non_zero_sum = 1l;
        int zeroes = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroes++;
            }
            else {
                non_zero_sum *= num;
            }
        }
        if (non_zero_sum > (long) Integer.MAX_VALUE) {
            throw new RuntimeException("An unexpected overflow has occured");
        }
        int sum_i = (int) non_zero_sum;
        int[] output = new int[nums.length];
        if (zeroes > 1) {
            return output;
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeroes == 1) {
                output[i] = nums[i] == 0 ? sum_i : 0;
            }
            else {
                output[i] = sum_i / nums[i];
            }
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
                if (target[j] != 0){
                    non_zero_product *= target[j];
                }
            }
            int[] expected = validate(Arrays.copyOf(target, target.length));
            int[] actual = solution.productExceptSelf(Arrays.copyOf(target, target.length));
            assertArrayEquals(expected, actual, Arrays.toString(target));
        }
    }
}