package earth.bermuda.leetcode.contest1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestoreTheArrayTest {

    @Test
    public void providedTest1() {
        String s = "1000";
        int k = 10000;
        int expected = 1;
        int actual = new RestoreTheArray().numberOfArrays(s, k);
    }

    @Test
    public void providedTest2() {
        String s = "1000";
        int k = 10000;
        int expected = 1;
        int actual = new RestoreTheArray().numberOfArrays(s, k);
    }

    @Test
    public void providedTest3() {
        String s = "1000";
        int k = 10000;
        int expected = 1;
        int actual = new RestoreTheArray().numberOfArrays(s, k);
    }

    @Test
    public void providedTest4() {
        String s = "1000";
        int k = 10000;
        int expected = 1;
        int actual = new RestoreTheArray().numberOfArrays(s, k);
    }

    @Test
    public void providedTest5() {
        String s = "1000";
        int k = 10000;
        int expected = 1;
        int actual = new RestoreTheArray().numberOfArrays(s, k);
    }
//    Input: s = "1000", k = 10000
//    Output: 1
//    Explanation: The only possible array is [1000]
//    Example 2:
//
//    Input: s = "1000", k = 10
//    Output: 0
//    Explanation: There cannot be an array that was printed this way and has all integer >= 1 and <= 10.
//    Example 3:
//
//    Input: s = "1317", k = 2000
//    Output: 8
//    Explanation: Possible arrays are [1317],[131,7],[13,17],[1,317],[13,1,7],[1,31,7],[1,3,17],[1,3,1,7]
//    Example 4:
//
//    Input: s = "2020", k = 30
//    Output: 1
//    Explanation: The only possible array is [20,20]. [2020] is invalid because 2020 > 30. [2,020] is ivalid because 020 contains leading zeros.
//            Example 5:
//
//    Input: s = "1234567890", k = 90
//    Output: 34
}