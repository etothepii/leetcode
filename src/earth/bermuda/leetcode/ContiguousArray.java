package earth.bermuda.leetcode;

import java.util.Arrays;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        char[] firstSeen = new char[100];
        int cum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cum++;
            }
            else {
                cum--;
            }
            if (cum == 0) {
                max = Math.max(max, i + 1);
                continue;
            }
            int index = cum < 0 ? ~ (cum << 1) : cum << 1;
            if (index >= firstSeen.length) {
                firstSeen = Arrays.copyOf(firstSeen, firstSeen.length * 10);
            }
            else if (firstSeen[index] > 0) {
                max = Math.max(max, i + 1 - firstSeen[index]);
            }
            else {
                firstSeen[index] = (char)(i + 1);
            }
        }
        return max;
    }
}
