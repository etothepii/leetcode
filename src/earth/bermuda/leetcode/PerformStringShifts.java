package earth.bermuda.leetcode;

import java.util.ArrayList;

public class PerformStringShifts {
    public String stringShift(String s, int[][] shift) {
        ArrayList<Character> chars = new ArrayList<>();
        for (char c : s.toCharArray()) {
            chars.add(c);
        }
        for (int i = 0; i < shift.length; i++) {
            char c = chars.remove(i);
            if (shift[i][0] == 0) {
                chars.add(Math.max(0, i - shift[i][1]), c);
            } else {
                chars.add(Math.min(chars.size(), i + shift[i][1]), c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }
}
