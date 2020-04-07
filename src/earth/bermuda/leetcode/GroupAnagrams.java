package earth.bermuda.leetcode;

import java.util.*;

public class GroupAnagrams {

    class Anagram {
        private final int[] charCount = new int[26];

        public Anagram(String string) {
            for (char c : string.toCharArray()) {
                charCount[c - 96]++;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Anagram anagram = (Anagram) o;
            return Arrays.equals(charCount, anagram.charCount);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(charCount);
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams = new ArrayList<>();
        Map<Anagram, List<String>> anagramMap = new HashMap<>();
        for (String str : strs) {
            Anagram anagram = new Anagram(str);
            List<String> strings = anagramMap.get(anagram);
            if (strings == null) {
                strings = new ArrayList<>();
                anagrams.add(strings);
                anagramMap.put(anagram, strings);
            }
            strings.add(str);
        }
        return anagrams;
    }
}
