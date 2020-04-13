package earth.bermuda.leetcode;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int cum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            cum += nums[i];
            nums[i] = cum;
            for (int j = max + 1; i - j * 2 + 1 >= 0; j++) {
                if (nums[i] - nums[i - j * 2 + 1] == j) {
                    max = j;
                }
            }
        }
        return max * 2;
    }
}
