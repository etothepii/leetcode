package earth.bermuda.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackspaceStringCompareTest {

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
}