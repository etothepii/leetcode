package earth.bermuda.leetcode.april;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int nonZeroIndex = nums[0] != 0 ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex++] = nums[i];
            }
        }
        for (; nonZeroIndex < nums.length; nonZeroIndex++) {
            nums[nonZeroIndex] = 0;
        }
    }
}
