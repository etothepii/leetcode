package earth.bermuda.leetcode;

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

}