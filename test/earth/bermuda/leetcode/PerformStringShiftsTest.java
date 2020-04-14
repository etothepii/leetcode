package earth.bermuda.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PerformStringShiftsTest {

    private static String validate(String s, int[][] shift) {
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

    @Test
    public void can_string_shift_1() {
        String s = "abc";
        int[][] shift = new int[][]{new int[]{0, 1}, new int[]{1, 2}};
        String expected = "cab";
        String actual = new PerformStringShifts().stringShift(s, shiftCopy(shift));
        assertEquals(expected, actual, s, shift);
    }

    @Test
    public void can_string_shift_2() {
        String s = "efgabcd";
        int[][] shift = new int[][]{new int[]{1, 1}, new int[]{1, 1}, new int[]{0, 2}, new int[]{1, 3}};
        String expected = "efgabcd";
        String actual = new PerformStringShifts().stringShift(s, shiftCopy(shift));
        assertEquals(expected, actual, s, shift);
    }

    @Test
    public void can_run_10_000() {
        PerformStringShifts solution = new PerformStringShifts();
        for (int i = 0; i < 10_000; i++) {
            String s = randomString(1 + (int) (Math.random() * 99));
            int[][] shift = randomShift((int) (Math.random() * s.length()));
            String expected = validate(s, shiftCopy(shift));
            String actual = solution.stringShift(s, shiftCopy(shift));
            assertEquals(expected, actual, s, shift);
        }
    }

    private void assertEquals(String expected, String actual, String s, int[][] shift) {
        if (!expected.equals(actual)) {
            StringBuilder sb = new StringBuilder(shift.length * 10 + 10);
            sb.append(s);
            sb.append(" == ");
            sb.append(actual);
            sb.append(" != ");
            sb.append(expected);
            sb.append(" after ");
            sb.append("[");
            for (int[] move : shift) {
                sb.append("[");
                sb.append(move[0]);
                sb.append(", ");
                sb.append(move[1]);
                sb.append("], ");
            }
            sb.setLength(sb.length() - 2);
            sb.append("]");
            assertEquals(expected, actual, sb.toString());
        }
    }

    private int[][] shiftCopy(int[][] shift) {
        int[][] copy = new int[shift.length][];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = Arrays.copyOf(shift[i], 2);
        }
        return copy;
    }

    private int[][] randomShift(int length) {
        int[][] shift = new int[length][];
        for (int i = 0; i < length; i++) {
            shift[i] = new int[]{(int) (Math.random() * 2), (int) (Math.random() * 101)};
        }
        return shift;
    }

    private String randomString(int size) {
        char[] s = new char[size];
        for (int i = 0; i < size; i++) {
            s[i] = (char) (Math.random() * 26 + 97);
        }
        return new String(s);
    }

}