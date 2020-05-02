package earth.bermuda.leetcode.april;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
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
}
