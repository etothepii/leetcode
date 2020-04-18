package earth.bermuda.leetcode.contest1;

import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsKTest {

    private int validate(int k) {
        int index = Arrays.binarySearch(FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK.F, k);
        if (index >= 0) {
            return 1;
        }
        int[] candidates = Arrays.copyOf(FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK.F, ~index);
        int upperBound = FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK.binPacking(candidates, k);
        return bruteForce(candidates, upperBound, k);
    }

    private int bruteForce(int[] candidates, int upperBound, int k) {
        int loopSize = candidates.length;
        for (int i = 2; i < upperBound; i++) {
            loopSize *= candidates.length;
            for (int j = 0; j < loopSize; j++) {
                int candidate = 0;
                int counter = j;
                for (int l = 0; l < i && candidate < k; l++) {
                    candidate += candidates[counter % candidates.length];
                    if (candidate == k) {
                        return i;
                    }
                    counter /= candidates.length;
                }
            }
        }
        return upperBound;
    }

    @Test
    public void testCase1() {
        int k = 7;
        int expected = validate(k);
        int actual = new FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK().findMinFibonacciNumbers(k);
        assertEquals(expected, actual, k + "");
    }

    @Test
    public void testCase2() {
        int k = 10;
        int expected = validate(k);
        int actual = new FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK().findMinFibonacciNumbers(k);
        assertEquals(expected, actual, k + "");
    }

    @Test
    public void testCase3() {
        int k = 19;
        int expected = validate(k);
        int actual = new FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK().findMinFibonacciNumbers(k);
        assertEquals(expected, actual, k + "");
    }

    @Test
    public void testCase4() {
        int k = 701408733;
        int expected = validate(k);
        int actual = new FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK().findMinFibonacciNumbers(k);
        assertEquals(expected, actual, k + "");
    }

    @Test
    public void testCase5() {
        int k = 1;
        int expected = validate(k);
        int actual = new FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK().findMinFibonacciNumbers(k);
        assertEquals(expected, actual, k + "");
    }

    @Test
    public void test_100() {
        for (int i = 0; i < 100; i++) {
            int k = (int)(Math.random() * 1e4);
            int expected = validate(k);
            int actual = new FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK().findMinFibonacciNumbers(k);
            assertEquals(expected, actual, k + "");
        }
    }

}