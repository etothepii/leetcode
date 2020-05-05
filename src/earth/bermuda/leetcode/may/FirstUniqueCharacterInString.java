package earth.bermuda.leetcode.may;

public class FirstUniqueCharacterInString {

    public int firstUniqChar(String s) {
        boolean[] seen = new boolean[26];
        boolean[] seenTwice = new boolean[26];
        int[] location = new int[26];
        int[] firstLocation = new int[26];
        int pointer = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 97;
            if (seenTwice[index]) {
                continue;
            }
            if (seen[index]) {
                seenTwice[index] = true;
                if (location[index] == pointer) {
                    while(seenTwice[++pointer]);
                }
                continue;
            }
            seen[index] = true;
            firstLocation[index] = i;
        }
        return pointer;
    }

}
