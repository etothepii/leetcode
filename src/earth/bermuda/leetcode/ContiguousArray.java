package earth.bermuda.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        char[] firstSeen = new char[10];
        int cum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            cum += nums[i] == 1 ? 1 : -1;
            int index = cum < 0 ? ~cum * 2 + 1 : cum * 2;
            if (index >= firstSeen.length) {
                firstSeen = Arrays.copyOf(firstSeen, firstSeen.length * 10);
            }
            if (cum == 0) {
                max = Math.max(max, i + 1);
            }
            else if (firstSeen[index] > 0) {
                max =  Math.max(max, i + 1 - firstSeen[index]);
            }
            else {
                firstSeen[index] = (char)(i + 1);
            }
        }
        return max;
    }
}
