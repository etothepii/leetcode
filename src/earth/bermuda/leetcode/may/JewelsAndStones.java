package earth.bermuda.leetcode.may;

public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {
        boolean[] jewels = new boolean[123];
        for (char j : J.toCharArray()) {
            jewels[j] = true;
        }
        int count = 0;
        for (char s : S.toCharArray()) {
            count += jewels[s] ? 1 : 0;
        }
        return count;
    }

}
