package earth.bermuda.leetcode.contest1;

import java.util.Arrays;

public class FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK {

    public static final int[] F = new int[] {
        1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368,
                75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352,
                24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733
    };

    public int findMinFibonacciNumbers(int k) {
        int index = Arrays.binarySearch(F, k);
        if (index >= 0) {
            return 1;
        }
        int[] candidates = Arrays.copyOf(F, ~index);
        return minimumSumFrom(candidates, k);
    }

    private int minimumSumFrom(int[] candidates, int k) {
        return this.binPacking(candidates, k);
    }

    private int binPacking(int[] candidates, int k) {
        int used = 0;
        for (int i = candidates.length - 1; i >= 0 && k > 0; i--) {
            if (k >= candidates[i]) {
                k -= candidates[i];
                used++;
            }
        }
        if (k != 0) {
            throw new RuntimeException(String.format("An expected situation has occured {%d}", k));
        }
        return used;
    }
}
