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
        assertEquals(actual, expected, target);
    }

    @Test
    public void can_convert_2() {
        String target = "   -42";
        int actual = new StringToInteger().myAtoi(target);
        int expected = -42;
        assertEquals(actual, expected, target);
    }

    @Test
    public void can_convert_3() {
        String target = "4193 with words";
        int actual = new StringToInteger().myAtoi(target);
        int expected = 4193;
        assertEquals(actual, expected, target);
    }

    @Test
    public void can_convert_4() {
        String target = "words and 987";
        int actual = new StringToInteger().myAtoi(target);
        int expected = 0;
        assertEquals(actual, expected, target);
    }

    @Test
    public void can_convert_5() {
        String target = "-91283472332";
        int actual = new StringToInteger().myAtoi(target);
        int expected = Integer.MIN_VALUE;
        assertEquals(actual, expected, target);
    }

    @Test
    public void can_convert_6() {
        String target = "91283472332";
        int actual = new StringToInteger().myAtoi(target);
        int expected = Integer.MAX_VALUE;
        assertEquals(actual, expected, target);
    }

}