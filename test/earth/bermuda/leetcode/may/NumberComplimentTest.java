package earth.bermuda.leetcode.may;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberComplimentTest {

    @Test
    public void exampleTest1() {
        int actual = new NumberCompliment().findComplement(1);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void exampleTest2() {
        int actual = new NumberCompliment().findComplement(5);
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void exampleTest3() {
        int actual = new NumberCompliment().findComplement(0);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void exampleTest4() {
        int actual = new NumberCompliment().findComplement(64);
        int expected = 63;
        assertEquals(expected, actual);
    }

    @Test
    public void exampleTest5() {
        int actual = new NumberCompliment().findComplement(63);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void exampleTest6() {
        int actual = new NumberCompliment().findComplement(Integer.MAX_VALUE);
        int expected = 0;
        assertEquals(expected, actual);
    }

}