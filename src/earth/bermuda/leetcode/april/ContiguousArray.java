package earth.bermuda.leetcode.april;

import java.util.Arrays;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        char[] firstSeen = new char[100];
        int cum = 0;
        int max = 0;
        char c = 0;
        while (c < nums.length) {
            cum += nums[c++] * 2 - 1;
            if (cum == 0) {
                max = Math.max(max, c);
            }
            else {
                int index = cum < 0 ? ~(cum << 1) : cum << 1;
                if (index >= firstSeen.length) {
                    firstSeen = Arrays.copyOf(firstSeen, firstSeen.length * 10);
                }
                if (firstSeen[index] > 0) {
                    max = Math.max(max, c - firstSeen[index]);
                } else {
                    firstSeen[index] = c;
                }
            }
        }
        return max;
    }
}
