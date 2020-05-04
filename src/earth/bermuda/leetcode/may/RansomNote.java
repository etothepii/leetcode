package earth.bermuda.leetcode.may;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        short[] letters = new short[26];
        for (char c : magazine.toCharArray()) {
            letters[c - 97]++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (--letters[c - 97] < 0) {
                return false;
            }
        }
        return true;
    }
}
