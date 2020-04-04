package earth.bermuda.leetcode;

/**
 * Created by james on 04/04/2020.
 */
public class StringToInteger {

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
            }
            else if (c == '-' && !started) {
                negative = true;
                started = true;
                continue;
            }
            started = true;
            if (c < 48 || c > 57) {
                break;
            }
            int new_value = value * 10 + (c - 48);
            if (new_value < value) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            value = new_value;
        }
        return negative ? -value : value;
    }
}
