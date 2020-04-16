package earth.bermuda.leetcode;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] up = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            up[i] = i == 0 ? 1 : (up[i - 1] * nums[i - 1]);
        }
        int multiplicand = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            up[i] *= multiplicand;
            multiplicand *= nums[i];
        }
        return up;
    }
}
