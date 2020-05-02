package earth.bermuda.leetcode.april;

import earth.bermuda.leetcode.april.HappyNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * Created by james on 03/04/2020.
 */
public class HappyNumberTest {

    private static int step(int n) {
        int count = 0;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            count += digit * digit;
        }
        return count;
    }

    private static boolean validate(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            if (n == 1) {
                return true;
            }
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            n = step(n);
        }
    }

    @Test
    public void test_is_happy_1() {
        boolean expected = true;
        boolean actual = new HappyNumber().isHappy(1212337955);
        Assertions.assertEquals(expected, actual, 1212337955 + "");
    }

    @Test
    public void test_100_000_times() {
        HappyNumber solution = new HappyNumber();
        for (int i = 0; i < 100000; i++) {
            int n = (int) (Math.random() * Integer.MAX_VALUE);
            boolean result = solution.isHappy(n);
            boolean expected = validate(n);
            Assertions.assertEquals(expected, result, n + "");
        }
        for (int n = 1; n <= 1000; n++) {
            boolean result = solution.isHappy(n);
            boolean expected = validate(n);
            Assertions.assertEquals(expected, result, n + "");
        }
    }

    @Test
    public void test_time() {
        HappyNumber solution = new HappyNumber();
        long target = 200_000_000L;
        long start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            int n = (int) (Math.random() * Integer.MAX_VALUE);
            solution.isHappy(n);
        }
        long taken = System.nanoTime() - start;
        Assertions.assertTrue(taken < target, taken + "ns > " + target + "ns");
    }

}
