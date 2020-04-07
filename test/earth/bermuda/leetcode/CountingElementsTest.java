package earth.bermuda.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CountingElementsTest {

    public static int validate(int[] target) {
        return new CountingElements().countElements(target);
    }

    @Test
    public void can_count_elements_1() {
        int[] target = new int[]{1, 2, 3};
        int expected = 2;
        int actual = new CountingElements().countElements(target);
        assertEquals(expected, actual, Arrays.toString(target));
    }

    @Test
    public void can_count_elements_2() {
        int[] target = new int[]{1, 1, 3, 3, 5, 5, 7, 7};
        int expected = 0;
        int actual = new CountingElements().countElements(target);
        assertEquals(expected, actual, Arrays.toString(target));
    }

    @Test
    public void can_count_elements_3() {
        int[] target = new int[]{1, 3, 2, 3, 5, 0};
        int expected = 3;
        int actual = new CountingElements().countElements(target);
        assertEquals(expected, actual, Arrays.toString(target));
    }

    @Test
    public void can_count_elements_4() {
        int[] target = new int[]{1, 1, 2, 2};
        int expected = 2;
        int actual = new CountingElements().countElements(target);
        assertEquals(expected, actual, Arrays.toString(target));
    }

    @Test
    public void can_run_10_000_validated_test() {
        long time = 0;
        for (int j = 0; j < 10_000; j++) {
            int[] target = new int[(int) (Math.random() * 1000 + 1)];
            for (int i = 0; i < target.length; i++) {
                target[i] = (int) (Math.random() * 1000);
            }
            int actual = new CountingElements().countElements(target);
            int expected = validate(target);
            assertEquals(expected, actual, Arrays.toString(target));
        }
    }

    @Test
    public void can_run_100_000_test() {
        long targetTime = 1_000_000;
        long time = 0;
        for (int j = 0; j < 100_000; j++) {
            int[] target = new int[(int) (Math.random() * 1000 + 1)];
            for (int i = 0; i < target.length; i++) {
                target[i] = (int) (Math.random() * 1000);
            }
            long start = System.nanoTime();
            validate(target);
            time += System.nanoTime() - start;
        }
        assertTrue(time < targetTime, time + "ns < " + targetTime + "ns");
    }
}