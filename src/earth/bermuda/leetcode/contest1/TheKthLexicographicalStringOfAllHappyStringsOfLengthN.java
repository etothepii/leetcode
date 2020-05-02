package earth.bermuda.leetcode.contest1;

public class TheKthLexicographicalStringOfAllHappyStringsOfLengthN {

    public String getHappyString(int n, int k) {
        k--;
        int binary_part = (int)(Math.pow(2, n - 1));
        if (k >= binary_part * 3) {
            return "";
        }
        StringBuilder sb = new StringBuilder(k);
        char previous = (new char[]{'a', 'b', 'c'})[k / binary_part];
        sb.append(previous);
        while (binary_part > 1) {
            int remained = k % binary_part;
            binary_part /= 2;
            int index = remained / binary_part;
            if (previous == 'a') {
                if (index == 0) {
                    previous = 'b';
                } else {
                    previous = 'c';
                }
            }
            else if (previous == 'b') {
                if (index == 0) {
                    previous = 'a';
                } else {
                    previous = 'c';
                }
            }
            else if (previous == 'c') {
                if (index == 0) {
                    previous = 'a';
                } else {
                    previous = 'b';
                }
            }
            sb.append(previous);
        }
        return sb.toString();
    }

}
