package earth.bermuda.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackspaceStringCompareTest {

    private static boolean oracle(String S, String T) {
        return removeBackspaces(S).equals(removeBackspaces(T));
    }

    private static String removeBackspaces(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                sb.setLength(Math.max(0, sb.length() - 1));
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    @Test
    public void can_backspace_compare_1() {
        String S = "ab#c";
        String T = "ad#c";
        boolean expected = true;
        boolean actual = new BackspaceStringCompare().backspaceCompare(S, T);
        assertEquals(expected, actual, expected ? (S + " == " + T) : (S + " != " + T));
    }

    @Test
    public void can_backspace_compare_2() {
        String S = "ab##", T = "c#d#";
        boolean expected = true;
        boolean actual = new BackspaceStringCompare().backspaceCompare(S, T);
        assertEquals(expected, actual, expected ? (S + " == " + T) : (S + " != " + T));
    }

    @Test
    public void can_backspace_compare_3() {
        String S = "a#c", T = "b";
        boolean expected = false;
        boolean actual = new BackspaceStringCompare().backspaceCompare(S, T);
        assertEquals(expected, actual, expected ? (S + " == " + T) : (S + " != " + T));
    }

    @Test
    public void can_backspace_compare_4() {
        String S = "a##c", T = "#a#c";
        boolean expected = true;
        boolean actual = new BackspaceStringCompare().backspaceCompare(S, T);
        assertEquals(expected, actual, expected ? (S + " == " + T) : (S + " != " + T));
    }

    @Test
    public void can_backspace_compare_5() {
        String S = "####", T = "###";
        boolean expected = true;
        boolean actual = new BackspaceStringCompare().backspaceCompare(S, T);
        assertEquals(expected, actual, expected ? (S + " == " + T) : (S + " != " + T));
    }

    @Test
    public void can_backspace_compare_6() {
        String S = "###a", T = "###";
        boolean expected = false;
        boolean actual = new BackspaceStringCompare().backspaceCompare(S, T);
        assertEquals(expected, actual, expected ? (S + " == " + T) : (S + " != " + T));
    }

    @Test
    public void can_backspace_compare_7() {
        String S = "abc##d", T = "ad";
        boolean expected = true;
        boolean actual = new BackspaceStringCompare().backspaceCompare(S, T);
        assertEquals(expected, actual, expected ? (S + " == " + T) : (S + " != " + T));
    }

    @Test
    public void can_backspace_compare_8() {
        String S = "a#b", T = "ba#";
        boolean expected = true;
        boolean actual = new BackspaceStringCompare().backspaceCompare(S, T);
        assertEquals(expected, actual, expected ? (S + " == " + T) : (S + " != " + T));
    }

    private static String generateSting(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append("#ab".charAt((int)(Math.random() * 3)));
        }
        return sb.toString();
    }

    @Test
    public void can_test_10_000() {
        BackspaceStringCompare solution = new BackspaceStringCompare();
        for (int i = 0; i < 10_000; i++) {
            int random = (int)(Math.random() * 5);
            String S = generateSting(random);
            String T = generateSting(random + (int)(Math.random() * 2));
            boolean expected = oracle(S, T);
            boolean actual = solution.backspaceCompare(S, T);
            assertEquals(expected, actual, expected ? (S + " == " + T) : (S + " != " + T));
            expected = oracle(T, S);
            actual = solution.backspaceCompare(T, S);
            assertEquals(expected, actual, expected ? (T + " == " + S) : (T + " != " + S));
        }
    }

    @Test
    public void can_validate_100_000() {
        BackspaceStringCompare solution = new BackspaceStringCompare();
        long target = 1;
        long taken = 0;
        for (int i = 0; i < 100_000; i++) {
            int random = (int)(Math.random() * 5);
            String S = generateSting(random);
            String T = generateSting(random + (int)(Math.random() * 2));
            long start = System.nanoTime();
            solution.backspaceCompare(S, T);
            taken += System.nanoTime() - start;
        }
        assertTrue(taken < target, taken + "ns < " + target + "ns");
    }
}