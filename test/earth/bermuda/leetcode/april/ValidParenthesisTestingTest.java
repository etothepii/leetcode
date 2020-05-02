package earth.bermuda.leetcode.april;

import earth.bermuda.leetcode.april.ValidParenthesisTesting;
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

    @Test
    public void can_validate_9() {
        String s = ")()";
        boolean expected = false;
        boolean actual = new ValidParenthesisTesting().checkValidString(s);
        assertEquals(expected, actual, s);
    }

    @Test
    public void can_validate_10() {
        String s = ")(**";
        boolean expected = false;
        boolean actual = new ValidParenthesisTesting().checkValidString(s);
        assertEquals(expected, actual, s);
    }

    @Test
    public void can_validate_11() {
        String s = "(()))";
        boolean expected = false;
        boolean actual = new ValidParenthesisTesting().checkValidString(s);
        assertEquals(expected, actual, s);
    }

    @Test
    public void can_validate_12() {
        String s = "((*))))";
        boolean expected = false;
        boolean actual = new ValidParenthesisTesting().checkValidString(s);
        assertEquals(expected, actual, s);
    }

    @Test
    public void can_validate_13() {
        String s = "(())((())()()(*)(*()(())())())()()((()())((()))(*";
        boolean expected = false;
        boolean actual = new ValidParenthesisTesting().checkValidString(s);
        assertEquals(expected, actual, s);
    }

    @Test
    public void can_validate_14() {
        String s = "**((*";
        boolean expected = false;
        boolean actual = new ValidParenthesisTesting().checkValidString(s);
        assertEquals(expected, actual, s);
    }

    @Test
    public void can_validate_15() {
        String s = "()(()(*(())()*)(*)))()))*)((()(*(((()())()))()()*)((*)))()))(*)(()()(((()*()()((()))((*((*)()";
        boolean expected = false;
        boolean actual = new ValidParenthesisTesting().checkValidString(s);
        assertEquals(expected, actual, s);
    }

    @Test
    public void can_validate_16() {
        String s = "***)))*)(((**)((*)))))(*)(()()(((()*()()((()))((*((*)()";
        boolean expected = false;
        boolean actual = new ValidParenthesisTesting().checkValidString(s);
        assertEquals(expected, actual, s);
    }

    @Test
    public void can_validate_17() {
        String s = "***)))*)***)*((((*((*(*";
        boolean expected = false;
        boolean actual = new ValidParenthesisTesting().checkValidString(s);
        assertEquals(expected, actual, s);
    }

}