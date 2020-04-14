package earth.bermuda.leetcode;

import java.util.HashMap;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> firstSeen = new HashMap<>();
        firstSeen.put(0, -1);
        int cum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            cum += nums[i] * 2 - 1;
            if (firstSeen.containsKey(cum)) {
                max = Math.max(max, i - firstSeen.get(cum));
            }
            else {
                firstSeen.put(cum, i);
            }
        }
        return max;
    }
}
