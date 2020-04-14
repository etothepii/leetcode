package earth.bermuda.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ContiguousArrayTest {

    private int validate(int[] nums) {
        int cum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            cum += nums[i];
            nums[i] = cum;
            if (cum == i * 2 - 1) {
                max = i;
                continue;
            }
            for (int j = max + 1; i - j * 2 >= 0; j++) {
                if (nums[i] - nums[i - j * 2] == j) {
                    max = j;
                }
            }
        }
        return max * 2;
    }

    @Test
    public void can_find_contiguous_array_1() {
        int[] target = new int[]{0, 1};
        int expected = 2;
        int actual = new ContiguousArray().findMaxLength(target);
        assertEquals(expected, actual, Arrays.toString(target));
    }

    @Test
    public void can_find_contiguous_array_2() {
        int[] target = new int[]{0, 1, 0};
        int expected = 2;
        int actual = new ContiguousArray().findMaxLength(target);
        assertEquals(expected, actual, Arrays.toString(target));
    }

    @Test
    public void can_find_contiguous_array_3() {
        int[] target = new int[]{0, 0, 0};
        int expected = 0;
        int actual = new ContiguousArray().findMaxLength(target);
        assertEquals(expected, actual, Arrays.toString(target));
    }

    @Test
    public void can_find_contiguous_array_4() {
        int[] target = new int[]{};
        int expected = 0;
        int actual = new ContiguousArray().findMaxLength(target);
        assertEquals(expected, actual, Arrays.toString(target));
    }

    @Test
    public void can_find_contiguous_array_5() {
        int[] target = new int[]{0,0,1,0,0,0,1,1};
        int expected = 6;
        int actual = new ContiguousArray().findMaxLength(target);
        assertEquals(expected, actual, Arrays.toString(target));
    }

    @Test
    public void can_find_contiguous_array_6() {
        int[] target = new int[]{0,1,0,1};
        int expected = 2;
        int actual = new ContiguousArray().findMaxLength(target);
        assertEquals(expected, actual, Arrays.toString(target));
    }

    @Test
    public void test_10_000() {
        ContiguousArray solution = new ContiguousArray();
        for (int i = 0; i < 10_000; i++) {
            int[] target = new int[(int) (Math.random() * 1000)];
            double p = Math.random();
            for (int j = 0; j < target.length; j++) {
                target[j] = Math.random() < p ? 0 : 1;
            }
            int expected = validate(Arrays.copyOf(target, target.length));
            int actual = solution.findMaxLength(target);
            assertEquals(expected, actual, Arrays.toString(target));
        }
    }

}