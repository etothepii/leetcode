package earth.bermuda.leetcode.april;

public class CountingElements {
    public int countElements(int[] arr) {
        boolean[] observed = new boolean[1001];
        int[] count = new int[1001];
        for (int i : arr) {
            count[i]++;
            observed[i] = true;
        }
        int total = 0;
        for (int i = 1; i < count.length; i++) {
            if (observed[i]) {
                total += count[i - 1];
            }
        }
        return total;
    }
}
