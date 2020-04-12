package earth.bermuda.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class LastStoneWeightTest {

    @Test
    public void can_last_stone_weight_1() {
        int[] target = new int[] {2,7,4,1,8,1};
        int expected = 1;
        int actual = new LastStoneWeight().lastStoneWeight(target);
        assertEquals(expected, actual, Arrays.toString(target));
    }

    @Test
    public void can_last_stone_weight_2() {
        int[] target = new int[] {1,1,1,1,1,1,1};
        int expected = 1;
        int actual = new LastStoneWeight().lastStoneWeight(target);
        assertEquals(expected, actual, Arrays.toString(target));
    }

    @Test
    public void can_last_stone_weight_3() {
        int[] target = new int[] {1,1,1,1,1,1};
        int expected = 0;
        int actual = new LastStoneWeight().lastStoneWeight(target);
        assertEquals(expected, actual, Arrays.toString(target));
    }

}