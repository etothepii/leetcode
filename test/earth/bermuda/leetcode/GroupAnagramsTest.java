package earth.bermuda.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GroupAnagramsTest {

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