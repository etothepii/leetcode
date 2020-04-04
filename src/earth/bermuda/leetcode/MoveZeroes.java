package earth.bermuda.leetcode;

public class MoveZeroes {
    public void moveZeroes(int[] actual) {
        int nonZeroIndex = 0;
        for (int i = 1; i < actual.length; i++) {
            if (actual[i] != 0) {
                actual[nonZeroIndex++] = actual[i];
            }
        }
        for (; nonZeroIndex < actual.length; nonZeroIndex++) {
            actual[nonZeroIndex] = 0;
        }
    }
}
