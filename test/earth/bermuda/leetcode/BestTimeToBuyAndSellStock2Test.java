package earth.bermuda.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Timer;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuyAndSellStock2Test {

    public int validate(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            if (profit > 0) {
                maxProfit += profit;
            }
        }
        return maxProfit;
    }

    @Test
    public void can_establish_max_profit_1() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int expected = 7;
        int actual = new BestTimeToBuyAndSellStock2().maxProfit(prices);
        assertEquals(expected, actual, Arrays.toString(prices));
    }

    @Test
    public void can_establish_max_profit_2() {
        int[] prices = new int[]{1, 2, 3, 4, 5};
        int expected = 4;
        int actual = new BestTimeToBuyAndSellStock2().maxProfit(prices);
        assertEquals(expected, actual, Arrays.toString(prices));
    }

    @Test
    public void can_establish_max_profit_3() {
        int[] prices = new int[]{7, 6, 4, 3, 1};
        int expected = 0;
        int actual = new BestTimeToBuyAndSellStock2().maxProfit(prices);
        assertEquals(expected, actual, Arrays.toString(prices));
    }

    @Test
    public void can_establish_max_profit_4() {
        int[] prices = new int[]{};
        int expected = 0;
        int actual = new BestTimeToBuyAndSellStock2().maxProfit(prices);
        assertEquals(expected, actual, Arrays.toString(prices));
    }

    @Test
    public void can_establish_max_profit_5() {
        int[] prices = new int[]{-1, -1, -1};
        int expected = 0;
        int actual = new BestTimeToBuyAndSellStock2().maxProfit(prices);
        assertEquals(expected, actual, Arrays.toString(prices));
    }

    @Test
    public void can_run_100_000_times() {
        BestTimeToBuyAndSellStock2 solution = new BestTimeToBuyAndSellStock2();
        for (int i = 0; i < 100_000; i++) {
            int[] prices = new int[(int) (50 * Math.random())];
            for (int j = 0; j < prices.length; j++) {
                prices[j] = (int) (Math.random() * 20000) - 10000;
            }
            int expected = validate(prices);
            int actual = solution.maxProfit(prices);
            assertEquals(expected, actual, Arrays.toString(prices));
        }
    }

    @Test
    public void can_run_1_000_000_times() {
        long target = 25_000_000;
        BestTimeToBuyAndSellStock2 solution = new BestTimeToBuyAndSellStock2();
        long running = 0;
        for (int i = 0; i < 100_000; i++) {
            int[] prices = new int[(int) (50 * Math.random())];
            for (int j = 0; j < prices.length; j++) {
                prices[j] = (int) (Math.random() * 20000) - 10000;
            }
            long start = System.nanoTime();
            solution.maxProfit(prices);
            running += System.nanoTime() - start;
        }
        Assertions.assertTrue(running < target, running + " > " + target);
    }


}