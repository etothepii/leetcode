package earth.bermuda.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesisTestingTest {

    @Test
    public void can_validate_1() {
        String s = "()";
        boolean expected = true;
        boolean actual = new ValidParenthesisTesting().checkValidString(s);
        assertEquals(expected, actual, s);
    }

    @Test
    public void can_validate_2() {
        String s = "(*)";
        boolean expected = true;
        boolean actual = new ValidParenthesisTesting().checkValidString(s);
        assertEquals(expected, actual, s);
    }

    @Test
    public void can_validate_3() {
        String s = "(*))";
        boolean expected = true;
        boolean actual = new ValidParenthesisTesting().checkValidString(s);
        assertEquals(expected, actual, s);
    }

    @Test
    public void can_validate_4() {
        String s = ")(";
        boolean expected = false;
        boolean actual = new ValidParenthesisTesting().checkValidString(s);
        assertEquals(expected, actual, s);
    }

    @Test
    public void can_validate_5() {
        String s = "(*";
        boolean expected = true;
        boolean actual = new ValidParenthesisTesting().checkValidString(s);
        assertEquals(expected, actual, s);
    }

    @Test
    public void can_validate_6() {
        String s = "";
        boolean expected = true;
        boolean actual = new ValidParenthesisTesting().checkValidString(s);
        assertEquals(expected, actual, s);
    }

    @Test
    public void can_validate_7() {
        String s = "(*)*(***************))";
        boolean expected = true;
        boolean actual = new ValidParenthesisTesting().checkValidString(s);
        assertEquals(expected, actual, s);
    }

    @Test
    public void can_validate_8() {
        String s = "(*)*(***************)()";
        boolean expected = true;
        boolean actual = new ValidParenthesisTesting().checkValidString(s);
        assertEquals(expected, actual, s);
    }

}