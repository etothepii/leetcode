package earth.bermuda.leetcode;

import java.util.ArrayList;

public class PerformStringShifts {
    public String stringShift(String s, int[][] shift) {
        ArrayList<Character> chars = new ArrayList<>();
        for (char c : s.toCharArray()) {
            chars.add(c);
        }
        for (int[] ints : shift) {
            for (int j = 0; j < ints[1]; j++) {
                if (ints[0] == 0) {
                    chars.add(chars.remove(0));
                } else {
                    chars.add(0, chars.remove(chars.size() - 1));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }
}
