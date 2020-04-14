package earth.bermuda.leetcode;

import java.util.Arrays;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        char[] firstSeen = new char[100];
        int cum = 0;
        int max = 0;
        char c = 0;
        for (int num : nums) {
            if (num == 0) {
                cum++;
            }
            else {
                cum--;
            }
            c++;
            if (cum == 0) {
                max = Math.max(max, c);
                continue;
            }
            int index = cum < 0 ? ~ (cum << 1) : cum << 1;
            if (index >= firstSeen.length) {
                firstSeen = Arrays.copyOf(firstSeen, firstSeen.length * 10);
            }
            if (firstSeen[index] > 0) {
                max = Math.max(max, c - firstSeen[index]);
            }
            else {
                firstSeen[index] = c;
            }
        }
        return max;
    }
}
