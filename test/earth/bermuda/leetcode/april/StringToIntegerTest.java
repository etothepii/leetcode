package earth.bermuda.leetcode.april;

import earth.bermuda.leetcode.april.StringToInteger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by james on 04/04/2020.
 */
class StringToIntegerTest {

    @Test
    public void can_convert_1() {
        String target = "42";
        int actual = new StringToInteger().myAtoi(target);
        int expected = 42;
        assertEquals(expected, actual, target);
    }

    @Test
    public void can_convert_2() {
        String target = "   -42";
        int actual = new StringToInteger().myAtoi(target);
        int expected = -42;
        assertEquals(expected, actual, target);
    }

    @Test
    public void can_convert_3() {
        String target = "4193 with words";
        int actual = new StringToInteger().myAtoi(target);
        int expected = 4193;
        assertEquals(expected, actual, target);
    }

    @Test
    public void can_convert_4() {
        String target = "words and 987";
        int actual = new StringToInteger().myAtoi(target);
        int expected = 0;
        assertEquals(expected, actual, target);
    }

    @Test
    public void can_convert_5() {
        String target = "-91283472332";
        int actual = new StringToInteger().myAtoi(target);
        int expected = Integer.MIN_VALUE;
        assertEquals(expected, actual, target);
    }

    @Test
    public void can_convert_6() {
        String target = "91283472332";
        int actual = new StringToInteger().myAtoi(target);
        int expected = Integer.MAX_VALUE;
        assertEquals(expected, actual, target);
    }

    @Test
    public void can_convert_7() {
        String target = "1a2";
        int actual = new StringToInteger().myAtoi(target);
        int expected = 1;
        assertEquals(expected, actual, target);
    }

    @Test
    public void can_convert_8() {
        String target = "-2147483649";
        int actual = new StringToInteger().myAtoi(target);
        int expected = -2147483648;
        assertEquals(expected, actual, target);
    }

    @Test
    public void can_convert_9() {
        String target = "2147483648";
        int actual = new StringToInteger().myAtoi(target);
        int expected = 2147483647;
        assertEquals(expected, actual, target);
    }

    @Test
    public void can_convert_10() {
        String target = "  0000000000012345678";
        int actual = new StringToInteger().myAtoi(target);
        int expected = 12345678;
        assertEquals(expected, actual, target);
    }

    @Test
    public void can_convert_11() {
        String target = "5034754778";
        int actual = new StringToInteger().myAtoi(target);
        int expected = Integer.MAX_VALUE;
        assertEquals(expected, actual, target);
    }

    @Test
    public void can_convert_12() {
        String target = "-000000000000001";
        int actual = new StringToInteger().myAtoi(target);
        int expected = -1;
        assertEquals(expected, actual, target);
    }

    @Test
    public void can_convert_13() {
        String target = "--0000000000001";
        int actual = new StringToInteger().myAtoi(target);
        int expected = 0;
        assertEquals(expected, actual, target);
    }

    @Test
    public void can_convert_14() {
        String target = "-+0000000000001";
        int actual = new StringToInteger().myAtoi(target);
        int expected = 0;
        assertEquals(expected, actual, target);
    }

    @Test
    public void can_convert_15() {
        String target = "  -0 451";
        int actual = new StringToInteger().myAtoi(target);
        int expected = 0;
        assertEquals(expected, actual, target);
    }

    @Test
    public void can_convert_16() {
        String target = "0-1";
        int actual = new StringToInteger().myAtoi(target);
        int expected = 0;
        assertEquals(expected, actual, target);
    }

    public static int validate(String str) {
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

    @Test
    public void can_test_100_000() {
        StringToInteger solution = new StringToInteger();
        for (int i = 0; i < 50_000; i++) {
            long target = (long) Math.pow(10d, Math.random() * 11);
            if (Math.random() < .5) {
                target = -target;
            }
            String str = target + "";
            int actual = solution.myAtoi(target + "");
            int expected = validate(str);
            assertEquals(expected, actual, target + "");
        }
        String charset = " +-09a";
        for (int i = 0; i < 50_000; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < (int)(11 * Math.random()); j++) {
                sb.append(charset.charAt((int)(charset.length() * Math.random())));
            }
            String str = sb.toString();
            int actual = solution.myAtoi(str);
            int expected = validate(str);
            assertEquals(expected, actual, str);
        }
    }

}