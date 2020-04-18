package earth.bermuda.leetcode.contest1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TheKthLexicographicalStringOfAllHappyStringsOfLengthNTest {

    @Test
    public void test1() {
        int n = 1, k = 3;
        String expected = "c";
        String actual = new TheKthLexicographicalStringOfAllHappyStringsOfLengthN().getHappyString(n, k);
        assertEquals(expected, actual, String.format("n: %d, k: %d", n, k));
    }

    @Test
    public void test2() {
        int n = 1, k = 4;
        String expected = "";
        String actual = new TheKthLexicographicalStringOfAllHappyStringsOfLengthN().getHappyString(n, k);
        assertEquals(expected, actual, String.format("n: %d, k: %d", n, k));
    }

    @Test
    public void test3() {
        int n = 3, k = 9;
        String expected = "cab";
        String actual = new TheKthLexicographicalStringOfAllHappyStringsOfLengthN().getHappyString(n, k);
        assertEquals(expected, actual, String.format("n: %d, k: %d", n, k));
    }

    @Test
    public void test4() {
        int n = 2, k = 7;
        String expected = "";
        String actual = new TheKthLexicographicalStringOfAllHappyStringsOfLengthN().getHappyString(n, k);
        assertEquals(expected, actual, String.format("n: %d, k: %d", n, k));
    }

    @Test
    public void test5() {
        int n = 10, k = 100;
        String expected = "abacbabacb";
        String actual = new TheKthLexicographicalStringOfAllHappyStringsOfLengthN().getHappyString(n, k);
        assertEquals(expected, actual, String.format("n: %d, k: %d", n, k));
    }

}