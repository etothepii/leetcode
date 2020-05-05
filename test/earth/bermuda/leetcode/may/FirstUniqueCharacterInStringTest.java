package earth.bermuda.leetcode.may;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstUniqueCharacterInStringTest {

    private static int workingSolution(String s) {
        if (s.length() == 0) {
            return -1;
        }
        int[] location = new int[26];
        int firstChar = s.charAt(0) - 97;
        for (int i = 1; i < s.length(); i++) {
            int index = s.charAt(i) - 97;
            if (location[index] == 0) {
                location[index] = i;
            }
            else {
                location[index] = -1;
            }
        }
        if (location[firstChar] == 0) {
            return 0;
        }
        else {
            location[firstChar] = -1;
        }
        int min = Integer.MAX_VALUE;
        for (int index : location) {
            if (index > 0) {
                min = Math.min(min, index);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    @Test
    public void providedExample1() {
        int actual = new FirstUniqueCharacterInString().firstUniqChar("leetcode");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void providedExample2() {
        int actual = new FirstUniqueCharacterInString().firstUniqChar("loveleetcode");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void providedExample3() {
        int actual = new FirstUniqueCharacterInString().firstUniqChar("");
        int expected = -1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void providedExample4() {
        int actual = new FirstUniqueCharacterInString().firstUniqChar("cc");
        int expected = -1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void run_100_000_times() {
        for (int i = 0; i < 100_000; i++) {
            StringBuilder sb = new StringBuilder();
            int length = (int)(Math.random() * 1000);
            for (int j = 0; j < length; j++) {
                sb.append((char)(Math.random() * 26 + 97));
            }
            int actual = new FirstUniqueCharacterInString().firstUniqChar(sb.toString());
            int expected = workingSolution(sb.toString());
            Assertions.assertEquals(expected, actual, sb.toString());
        }
    }

}