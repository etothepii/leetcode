package earth.bermuda.leetcode;

/**
 * Created by james on 04/04/2020.
 */
public class StringToInteger {

    public static final int[][] digits = new int[][]{
            new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
            new int[]{0, 10, 20, 30, 40, 50, 60, 70, 80, 90},
            new int[]{0, 100, 200, 300, 400, 500, 600, 700, 800, 900},
            new int[]{0, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000},
            new int[]{0, 10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000},
            new int[]{0, 100000, 200000, 300000, 400000, 500000, 600000, 700000, 800000, 900000},
            new int[]{0, 1000000, 2000000, 3000000, 4000000, 5000000, 6000000, 7000000, 8000000, 9000000},
            new int[]{0, 10000000, 20000000, 30000000, 40000000, 50000000, 60000000, 70000000, 80000000, 90000000},
            new int[]{0, 100000000, 200000000, 300000000, 400000000, 500000000, 600000000, 700000000, 800000000, 900000000},
            new int[]{0, 1000000000, 2000000000}
    };

    public int myAtoi(String str) {
        int value = 0;
        boolean negative = false;
        boolean started = false;
        for (char c : str.toCharArray()) {
            if (c == ' ' && !started) {
                continue;
            }
            if (c == '+' && !started) {
                started = true;
                continue;
            } else if (c == '-' && !started) {
                negative = true;
                started = true;
                continue;
            }
            started = true;
            if (c < 48 || c > 57) {
                break;
            }
            if (negative && (value > 214748364 || (value == 214748364 && (c - 48) >= 8))) {
                return Integer.MIN_VALUE;
            }
            if (!negative && (value > 214748364 || (value == 214748364 && (c - 48) >= 7))) {
                return Integer.MAX_VALUE;
            }
            value = value * 10 + (c - 48);
        }
        return negative ? -value : value;
    }
}
