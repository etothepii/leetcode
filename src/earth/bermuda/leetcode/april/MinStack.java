package earth.bermuda.leetcode.april;

import java.util.Arrays;

public class MinStack {

    private final int[] list = new int[7_501];
    private final int[] min = new int[7_501];
    private short list_pointer = 0;

    public MinStack() {
        list[0] = Integer.MAX_VALUE;
        min[0] = Integer.MAX_VALUE;
    }

    public void push(int x) {
        int new_min = Math.min(x, min[list_pointer]);
        min[++list_pointer] = new_min;
        list[list_pointer] = x;
    }

    public void pop() {
        list_pointer--;
    }

    public int top() {
        return list[list_pointer];
    }

    public int getMin() {
        return min[list_pointer];
    }
}
