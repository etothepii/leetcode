package earth.bermuda.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuyAndSellStock2Test {

    @Test
    public void can_establish_max_profit_1() {
        int[] prices = new int[] {7,1,5,3,6,4};
        int expected = 7;
        int actual = new BestTimeToBuyAndSellStock2().maxProfit(prices);
        assertEquals(expected, actual, Arrays.toString(prices));
    }

    @Test
    public void can_establish_max_profit_2() {
        int[] prices = new int[] {1,2,3,4,5};
        int expected = 4;
        int actual = new BestTimeToBuyAndSellStock2().maxProfit(prices);
        assertEquals(expected, actual, Arrays.toString(prices));
    }

    @Test
    public void can_establish_max_profit_3() {
        int[] prices = new int[] {7,6,4,3,1};
        int expected = 0;
        int actual = new BestTimeToBuyAndSellStock2().maxProfit(prices);
        assertEquals(expected, actual, Arrays.toString(prices));
    }

    @Test
    public void can_establish_max_profit_4() {
        int[] prices = new int[] {};
        int expected = 0;
        int actual = new BestTimeToBuyAndSellStock2().maxProfit(prices);
        assertEquals(expected, actual, Arrays.toString(prices));
    }

    @Test
    public void can_establish_max_profit_5() {
        int[] prices = new int[] {-1,-1, -1};
        int expected = 0;
        int actual = new BestTimeToBuyAndSellStock2().maxProfit(prices);
        assertEquals(expected, actual, Arrays.toString(prices));
    }


}