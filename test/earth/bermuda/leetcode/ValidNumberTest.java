package earth.bermuda.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by james on 02/04/2020.
 */
public class ValidNumberTest {
    @Test
    public void test_is_number_1() {
        ValidNumber solution = new ValidNumber();
        assertTrue(solution.isNumber("0"));
    }

    @Test
    public void test_is_number_2() {
        ValidNumber solution = new ValidNumber();
        assertTrue(solution.isNumber("0"));
    }

    @Test
    public void test_is_number_3() {
        ValidNumber solution = new ValidNumber();
        assertTrue(solution.isNumber(" 0.1 "));
    }

    @Test
    public void test_is_number_4() {
        ValidNumber solution = new ValidNumber();
        assertTrue(solution.isNumber("2e10"));
    }

    @Test
    public void test_is_number_5() {
        ValidNumber solution = new ValidNumber();
        assertTrue(solution.isNumber(" -90e3   "));
    }

    @Test
    public void test_is_number_6() {
        ValidNumber solution = new ValidNumber();
        assertTrue(solution.isNumber(" 6e-1"));
    }

    @Test
    public void test_is_number_7() {
        ValidNumber solution = new ValidNumber();
        assertTrue(solution.isNumber("53.5e93"));
    }

    @Test
    public void test_is_number_8() {
        ValidNumber solution = new ValidNumber();
        assertTrue(solution.isNumber("3."));
    }

    @Test
    public void test_is_not_number_1() {
        ValidNumber solution = new ValidNumber();
        assertFalse(solution.isNumber("abc"));
    }

    @Test
    public void test_is_not_number_2() {
        ValidNumber solution = new ValidNumber();
        assertFalse(solution.isNumber("1 a"));
    }

    @Test
    public void test_is_not_number_3() {
        ValidNumber solution = new ValidNumber();
        assertFalse(solution.isNumber(" 1e"));
    }

    @Test
    public void test_is_not_number_4() {
        ValidNumber solution = new ValidNumber();
        assertFalse(solution.isNumber("e3"));
    }

    @Test
    public void test_is_not_number_5() {
        ValidNumber solution = new ValidNumber();
        assertFalse(solution.isNumber(" 99e2.5 "));
    }

    @Test
    public void test_is_not_number_6() {
        ValidNumber solution = new ValidNumber();
        assertFalse(solution.isNumber(" --6"));
    }

    @Test
    public void test_is_not_number_7() {
        ValidNumber solution = new ValidNumber();
        assertFalse(solution.isNumber("-+3"));
    }

    @Test
    public void test_is_not_number_8() {
        ValidNumber solution = new ValidNumber();
        assertFalse(solution.isNumber("95a54e53"));
    }

    @Test
    public void test_is_not_number_9() {
        ValidNumber solution = new ValidNumber();
        assertFalse(solution.isNumber(""));
    }

    @Test
    public void test_is_not_number_10() {
        ValidNumber solution = new ValidNumber();
        assertFalse(solution.isNumber("                 "));
    }

    @Test
    public void test_is_not_number_11() {
        ValidNumber solution = new ValidNumber();
        assertFalse(solution.isNumber("203EE1"));
    }

    @Test
    public void test_is_not_number_12() {
        ValidNumber solution = new ValidNumber();
        assertFalse(solution.isNumber(". E202"));
    }

    @Test
    public void test_is_not_number_13() {
        ValidNumber solution = new ValidNumber();
        assertFalse(solution.isNumber("+..e01"));
    }

    @Test
    public void test_is_not_number_14() {
        ValidNumber solution = new ValidNumber();
        assertFalse(solution.isNumber("1221Ee"));
    }

    @Test
    public void test_random_10000() {
        ValidNumber solution = new ValidNumber();
        for (int i = 0; i < 10000; i++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < 6; x++) {
                sb.append("120.eE+- 3".charAt((int)(Math.random() * 10)));
            }
            String s = sb.toString();
            boolean is_int = true;
            try {
                Integer.parseInt(s);
            }
            catch (NumberFormatException nfe) {
                is_int = false;
            }
            boolean is_double = true;
            try {
                Double.parseDouble(s);
            }
            catch (NumberFormatException nfe) {
                is_double = false;
            }
            boolean expected = (is_double || is_int);
            boolean result = solution.isNumber(sb.toString());
            if (result != expected) {
                System.out.print(expected);
                System.out.print(": ");
                System.out.println(s);
            }
        }
    }
}
