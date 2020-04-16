package earth.bermuda.leetcode;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
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
}
