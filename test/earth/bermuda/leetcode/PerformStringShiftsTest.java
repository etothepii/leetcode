package earth.bermuda.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PerformStringShiftsTest {

    private static String validate(String s, int[][] shift) {
        return null;
    }

    @Test
    public void can_string_shift_1() {
        String s = "abc";
        int[][] shift = new int[][]{new int[]{0, 1}, new int[]{1, 2}};
        String expected = "cab";
        String actual = new PerformStringShifts().stringShift(s, shift);
    }

    @Test
    public void can_string_shift_2() {
        String s = "efgabcd";
        int[][] shift = new int[][]{new int[]{1, 1}, new int[]{1, 1}, new int[]{0, 2}, new int[]{1, 3}};
        String expected = "efgabcd";
        String actual = new PerformStringShifts().stringShift(s, shift);
    }

    @Test
    public void can_run_10_000() {
        PerformStringShifts solution = new PerformStringShifts();
        for (int i = 0; i < 10_000; i++) {
            String s = randomString(1 + (int)(Math.random() * 99));
            int[][] shift = randomShift(s.length());
            int[][] shift_2 = shiftCopy(shift);
            String expected = validate(s, shift);
            String actual = solution.stringShift(s, shift_2);
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
            shift[i] = new int[] {(int)(Math.random() * 2), (int)(Math.random() * 101)};
        }
        return shift;
    }

    private String randomString(int size) {
        char[] s = new char[size];
        for (int i = 0; i < size; i++) {
            s[i] = (char)(Math.random() * 26 + 97);
        }
        return new String(s);
    }

}