package earth.bermuda.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MoveZeroesTest {

    public static int[] validate(int[] num) {
        int[] result = new int[num.length];
        int result_index = 0;
        for (int value : num) {
            if (value != 0) {
                result[result_index++] = value;
            }
        }
        return result;
    }

    @Test
    public void move_zeroes_1() {
        int[] actual = new int[]{0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(actual);
        int[] expected = new int[]{1, 3, 12, 0, 0};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void move_zeroes_2() {
        int[] actual = new int[0];
        new MoveZeroes().moveZeroes(actual);
        int[] expected = new int[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    public void move_zeroes_3() {
        int[] actual = new int[]{0};
        new MoveZeroes().moveZeroes(actual);
        int[] expected = new int[]{0};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void move_zeroes_4() {
        int[] actual = new int[]{1, -1, 0, 0};
        new MoveZeroes().moveZeroes(actual);
        int[] expected = new int[]{1, -1, 0, 0};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void move_zeroes_5() {
        int[] actual = new int[]{0, 0, 1, -1};
        new MoveZeroes().moveZeroes(actual);
        int[] expected = new int[]{1, -1, 0, 0};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void move_zeroes_6() {
        int[] actual = new int[] {-1115682992, -166243870, 843523480, 79091299, 0, -1732776902, -333044963};
        new MoveZeroes().moveZeroes(actual);
        int[] expected = new int[]{-1115682992, -166243870, 843523480, 79091299, -1732776902, -333044963, 0};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void test_1000_times() {
        MoveZeroes moveZeroes = new MoveZeroes();
        for (int i = 0; i < 1000; i++) {
            int size = (int) (Math.random() * 1000);
            double p = (i % 100) / 100d;
            int[] actual = new int[size];
            for (int j = 0; j < size; j++) {
                if (Math.random() < p) {
                    actual[j] = 0;
                } else if (Math.random() < .5) {
                    actual[j] = (int) (Math.random() * Integer.MAX_VALUE);
                } else {
                    actual[j] = (int) (Math.random() * Integer.MIN_VALUE);
                }
            }
            String start = Arrays.toString(actual);
            int[] expected = validate(actual);
            moveZeroes.moveZeroes(actual);
            assertArrayEquals(expected, actual, String.format(
                    "%s -> %s != %s", start, Arrays.toString(actual), Arrays.toString(expected)));
        }
    }

}