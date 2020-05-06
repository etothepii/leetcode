package earth.bermuda.leetcode.may;

public class FirstUniqueCharacterInString {

    public int firstUniqChar(String s) {
        boolean[] seen = new boolean[27];
        boolean[] seenTwice = new boolean[27];
        int[] location = new int[27];
        int[] locationLetter = new int[27];
        int pointer = 0;
        int locationLetterSize = 0;
        for (int i = 1; i <= s.length(); i++) {
            int index = s.charAt(i - 1) - 96;
            if (seen[index]) {
                seenTwice[index] = true;
                while (locationLetter[pointer] > 0 && seenTwice[locationLetter[pointer]]) {
                    pointer++;
                    if (pointer == 26) {
                        return -1;
                    }
                }
            }
            else if (!seenTwice[index]) {
                seen[index] = true;
                location[index] = i;
                locationLetter[locationLetterSize++] = index;
            }
        }
        return pointer == locationLetterSize ? -1 : location[locationLetter[pointer]] - 1;
    }

}
