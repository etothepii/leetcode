package earth.bermuda.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        ArrayList<Integer> stone_list = new ArrayList<>();
        for (int stone : stones) {
            stone_list.add(stone);
        }
        while (stone_list.size() > 1) {
            Integer x = stone_list.remove(stone_list.size() - 2);
            Integer y = stone_list.remove(stone_list.size() - 1);
            if (y > x) {
                Integer z = y - x;
                int index = Collections.binarySearch(stone_list, z);
                if (index < 0) {
                    stone_list.add(~index, z);
                }
                else {
                    stone_list.add(index, z);
                }
            }
        }
        return stone_list.size() > 0 ? stone_list.get(0) : 0;
    }
}
