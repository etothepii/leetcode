package earth.bermuda.leetcode.april;

import java.util.Arrays;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int size = stones.length;
        while (size > 1) {
            int y = stones[--size];
            int x = stones[--size];
            if (y > x) {
                int z = y - x;
                int index = Arrays.binarySearch(stones, 0, size, z);
                if (index < 0) {
                    index = ~index;
                }
                System.arraycopy(stones, index, stones, index + 1, ++size - index);
                stones[index] = z;
            }
        }
        return size > 0 ? stones[0] : 0;
    }
}

