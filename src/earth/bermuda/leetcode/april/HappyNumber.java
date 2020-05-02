package earth.bermuda.leetcode.april;

/**
 * Created by james on 03/04/2020.
 */
public class HappyNumber {

    public static boolean[] isHappy = new boolean[]{false,
            true, false, false, false, false, false, true, false, false, true,
            false, false, true, false, false, false, false, false, true, false,
            false, false, true, false, false, false, false, true, false, false,
            true, true, false, false, false, false, false, false, false, false,
            false, false, false, true, false, false, false, false, true, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, true, false, true,
            false, false, false, false, false, false, false, false, true, false,
            false, true, false, false, false, true, false, false, false, false,
            true, false, false, true, false, false, true, false, false, true,
            false, false, true, false, false, false, false, false, true, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, true, true,
            false, false, true, false, false, false, false, false, true, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, true, false, false, false,
            false, false, false, false, false, true, false, false, false, false,
            false, false, false, false, false, false, false, true, false, true,
            false, true, true, false, false, false, false, false, false, false,
            false, false, true, false, false, false, false, true, false, false,
            false, false, false, false, false, false, false, false, true, false,
            false, false, false, false, false, true, false, false, false, true,
            false, false, false, false, false, true, false, false, true, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, true, true, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, true,
            false, false, false, false, false, false, false, false, false, false,
            true, false, true, false, false, false, false, false, false, false,
            true, true, false, false, false, false, false, false, false, true,
            false, false, true, false, false, false, false, false, true, true,
            false, false, false, false, false, true, false, false, true, false,
            true, false, false, false, false, false, false, true, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, true, false, false, false, false,
            false, true, false, false, true, false, true, true, false, false,
            false, false, false, false, false, true, false, false, true, false,
            false, false, true, false, false, true, false, false, false, false,
            true, true, false, false, false, false, true, false, false, false,
            false, false, false, true, false, false, false, false, true, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, true,
            false, false, false, false, false, true, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, true, false, false, false, false, true, false,
            false, false, false, false, false, false, false, true, false, false,
            false, false, false, false, false, false, true, false, false, true,
            false, false, false, false, false, true, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, true, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, true, false, false, false, false,
            false, false, true, false, true, true, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, true, false, false,
            false, false, false, false, false, false, true, false, false, false,
            false, true, true, false, false, false, false, false, false, false,
            false, true, false, false, true, false, true, true, false, false,
            false, false, false, true, false, false, false, false, true, false,
            false, false, true, false, true, true, false, false, false, false,
            false, false, false, false, true, false, false, false, false, false,
            true, false, true, false, false, false, false, false, false, true,
            false, false, true, false, false, false, false, false, false, false,
            false, false, false, true, false, false, false, false, false, true,
            false, false, false, false, false, false, false, false, true, false,
            false, false, false, false, false, true, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false};

    public static final int[] squares = new int[] {0,1,4,9,16,25,36,49,64,81};

    public boolean isHappy(int n) {
        if (n <= 733) {
            return isHappy[n];
        }
        int count = 0;
        for (char c : Integer.toString(n).toCharArray()) {
            count += squares[c - 48];
        }
        return isHappy[count];
    }
}
