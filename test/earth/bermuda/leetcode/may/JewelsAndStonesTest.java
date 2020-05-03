package earth.bermuda.leetcode.may;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JewelsAndStonesTest {
    @Test
    public void exampletest1() {
        String J = "aA", S = "aAAbbbb";
        int actual = new JewelsAndStones().numJewelsInStones(J, S);
        int expected = 3;
        assertEquals(expected, actual, String.format("%s, %s -> %d != %d", J, S, actual, expected));
    }

    @Test
    public void exampleTest2() {
        String J = "z", S = "ZZ";
        int actual = new JewelsAndStones().numJewelsInStones(J, S);
        int expected = 0;
        assertEquals(expected, actual, String.format("%s, %s -> %d != %d", J, S, actual, expected));
    }

    @Test
    public void edgeCase1() {
        String J = "a", S = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int actual = new JewelsAndStones().numJewelsInStones(J, S);
        int expected = 1;
        assertEquals(expected, actual, String.format("%s, %s -> %d != %d", J, S, actual, expected));
    }

    @Test
    public void edgeCase2() {
        String J = "A", S = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int actual = new JewelsAndStones().numJewelsInStones(J, S);
        int expected = 1;
        assertEquals(expected, actual, String.format("%s, %s -> %d != %d", J, S, actual, expected));
    }

    @Test
    public void edgeCase3() {
        String J = "z", S = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int actual = new JewelsAndStones().numJewelsInStones(J, S);
        int expected = 1;
        assertEquals(expected, actual, String.format("%s, %s -> %d != %d", J, S, actual, expected));
    }

    @Test
    public void edgeCase4() {
        String J = "Z", S = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int actual = new JewelsAndStones().numJewelsInStones(J, S);
        int expected = 1;
        assertEquals(expected, actual, String.format("%s, %s -> %d != %d", J, S, actual, expected));
    }
}