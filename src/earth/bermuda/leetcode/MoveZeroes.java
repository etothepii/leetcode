package earth.bermuda.leetcode;

public class MoveZeroes {
    public void moveZeroes(int[] actual) {
        if (actual.length == 0) {
            return;
        }
        int nonZeroIndex = actual[0] != 0 ? 1 : 0;
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
