package earth.bermuda.leetcode;

import java.util.HashMap;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        short[] firstSeen = new short[50_001];
        boolean[] seen = new boolean[50_001];
        firstSeen[25_000] = -1;
        seen[25_000] = true;
        int cum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            cum += nums[i] * 2 - 1;
            if (Math.abs(cum) > 25_000) {
                break;
            }
            if (seen[cum + 25_000]) {
                max =  Math.max(max, i - firstSeen[cum + 25_000]);
            }
            else {
                firstSeen[cum + 25_000] = (short)i;
                seen[cum + 25_000] = true;
            }
        }
        return max;
    }
}
