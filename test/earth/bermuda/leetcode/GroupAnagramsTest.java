package earth.bermuda.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GroupAnagramsTest {

    public static List<List<String>> validate(String[] strs) {
        HashMap<String, List<String>> strings = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = String.copyValueOf(chars);
            List<String> list = strings.get(sorted);
            if (list == null) {
                list = new ArrayList<>();
                strings.put(sorted, list);
            }
            list.add(str);
        }
        return Arrays.asList(strings.values().toArray(new List[0]));
    }

    @Test
    public void can_group_anagrams_1() {
        String[] target = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> actual = new GroupAnagrams().groupAnagrams(target);
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("ate","eat","tea"),
                Arrays.asList("nat","tan"),
                Collections.singletonList("bat")
        );
        assertEquals(toSet(expected), toSet(actual), Arrays.toString(target));
    }

    @Test
    public void can_group_anagrams_2() {
        String[] target = new String[] { "aaa", "aab", "aba", "baa"};
        List<List<String>> actual = new GroupAnagrams().groupAnagrams(target);
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("baa","aba","aab"),
                Collections.singletonList("aaa")
        );
        assertEquals(toSet(expected), toSet(actual), Arrays.toString(target));
    }

    private static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    private static String[] getWords() {
        char[] chars = new char[(int)(Math.random() * 15 + 1)];
        for (int j = 0; j < chars.length; j++) {
            chars[j] = alphabet[(int)(Math.random() * alphabet.length)];
        }
        String[] strs = new String[(int)(Math.random() * 100)];
        for (int j = 0; j < strs.length; j++) {
            char[] word = new char[(int)(Math.random() * 7)];
            for (int k = 0; k < word.length; k++) {
                word[k] = chars[(int)(Math.random() * chars.length)];
            }
            strs[j] = String.copyValueOf(word);
        }
        return strs;
    }

    @Test
    public void can_pass_10_000() {
        GroupAnagrams solution = new GroupAnagrams();
        for (int i = 0; i < 10_000; i++) {
            String[] target = getWords();
            List<List<String>> actual = solution.groupAnagrams(target);
            List<List<String>> expected = validate(target);
            assertEquals(toSet(expected), toSet(actual), Arrays.toString(target));
        }
    }

    @Test
    public void perf_test_100_000() {
        GroupAnagrams solution = new GroupAnagrams();
        long nanos = 30_000_000;
        long target = 1;
        for (int i = 0; i < 10_000; i++) {
            String[] strs = getWords();
            long start = System.nanoTime();
            solution.groupAnagrams(strs);
            nanos += System.nanoTime() - start;
        }
        assertTrue(nanos < target, nanos + " < " + target);
    }

    private static Set<Set<String>> toSet(List<List<String>> strings) {
        Set<Set<String>> sets = new HashSet<>();
        for (List<String> list : strings) {
            Set<String> set = new HashSet<>();
            for (String string : list) {
                set.add(string);
            }
            sets.add(set);
        }
        return sets;
    }
}