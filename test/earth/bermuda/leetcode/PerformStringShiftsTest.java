package earth.bermuda.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerformStringShiftsTest {

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

}