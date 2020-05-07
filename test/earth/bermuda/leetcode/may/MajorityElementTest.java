package earth.bermuda.leetcode.may;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MajorityElementTest {

    @Test
    public void providedExample1() {
        int actual = new MajorityElement().majorityElement(new int[] {3,2,3});
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void providedExample2() {
        int actual = new MajorityElement().majorityElement(new int[] {2,2,1,1,1,2,2});
        int expected = 2;
        assertEquals(expected, actual);
    }

}