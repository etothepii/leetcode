package earth.bermuda.leetcode.may;

import earth.bermuda.leetcode.may.FirstBadVersion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstBadVersionTest {

    @Test
    public void test_finds_fail_1() {
        int expected = 4;
        int tryVersion = 5;
        FirstBadVersion firstBadVersion = new FirstBadVersion(expected);
        int actual = firstBadVersion.firstBadVersion(tryVersion);
        Assertions.assertEquals(expected, actual, String.format("%d, %d", expected, tryVersion));
    }

    @Test
    public void test_finds_fail_2() {
        int expected = 5;
        int tryVersion = 1000_000;
        FirstBadVersion firstBadVersion = new FirstBadVersion(expected);
        int actual = firstBadVersion.firstBadVersion(tryVersion);
        Assertions.assertEquals(expected, actual, String.format("%d, %d", expected, tryVersion));
    }

    @Test
    public void test_finds_fail_3() {
        int expected = 1;
        int tryVersion = 2;
        FirstBadVersion firstBadVersion = new FirstBadVersion(expected);
        int actual = firstBadVersion.firstBadVersion(tryVersion);
        Assertions.assertEquals(expected, actual, String.format("%d, %d", expected, tryVersion));
    }

    @Test
    public void test_finds_fail_4() {
        int expected = 17;
        int tryVersion = 17;
        FirstBadVersion firstBadVersion = new FirstBadVersion(expected);
        int actual = firstBadVersion.firstBadVersion(tryVersion);
        Assertions.assertEquals(expected, actual, String.format("%d, %d", expected, tryVersion));
    }
}
