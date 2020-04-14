package earth.bermuda.leetcode;

import java.util.ArrayList;

public class PerformStringShifts {
    public String stringShift(String s, int[][] shift) {
        short total = 0;
        for (int [] rotate : shift) {
            if (rotate[0] == 0) {
                total -= rotate[1];
            }
            else {
                total += rotate[1];
            }
        }
        total %= s.length();
        if (total < 0) {
            total += s.length();
        }
        char[] original = s.toCharArray();
        char[] chars = new char[s.length()];
        System.arraycopy(original, 0, chars, total, chars.length - total);
        System.arraycopy(original, chars.length - total, chars, 0, total);
        return new String(chars);
    }
}
