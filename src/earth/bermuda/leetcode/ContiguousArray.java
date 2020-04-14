package earth.bermuda.leetcode;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int cum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            cum += nums[i];
            nums[i] = cum;
            if (cum == i * 2 - 1) {
                max = i;
                continue;
            }
            for (int j = max + 1; i - j * 2 >= 0; j++) {
                if (nums[i] - nums[i - j * 2] == j) {
                    max = j;
                }
            }
        }
        return max * 2;
    }
}
