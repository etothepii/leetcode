package earth.bermuda.leetcode.contest1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsKTest {

    @Test
    public void testCase1() {
        int k = 7;
        int expected = 2;
        int actual = new FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK().findMinFibonacciNumbers(k);
        assertEquals(expected, actual, k);
    }

    @Test
    public void testCase2() {
        int k = 10;
        int expected = 2;
        int actual = new FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK().findMinFibonacciNumbers(k);
        assertEquals(expected, actual, k);
    }

    @Test
    public void testCase3() {
        int k = 19;
        int expected = 3;
        int actual = new FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK().findMinFibonacciNumbers(k);
        assertEquals(expected, actual, k);
    }

}