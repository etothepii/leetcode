package earth.bermuda.leetcode;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        up[0] = 1;
        down[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            up[i] = up[i - 1] * nums[i - 1];
            down[nums.length - 1 - i] = down[nums.length - i] * nums[nums.length - i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = up[i] * down[i];
        }
        return nums;
    }
}
