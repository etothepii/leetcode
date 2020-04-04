package earth.bermuda.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveZeroesTest {

    @Test
    public void move_zeroes_1() {
        int[] actual = new int[] {0,1,0,3,12};
        new MoveZeroes().moveZeroes(actual);
        int[] expected = new int[] {1, 3, 12, 0, 0};
        assertArrayEquals(expected, actual);
    }

}