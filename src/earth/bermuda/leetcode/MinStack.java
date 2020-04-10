package earth.bermuda.leetcode;

import java.util.Arrays;

public class MinStack {

    private int[] list = new int[10];
    private int[] min_indexes = new int[10];
    private int list_pointer = -1;
    private int min_indexes_pointer = -1;

    public MinStack() {}

    public void push(int x) {
        list_pointer++;
        if (list_pointer == list.length) {
            list = Arrays.copyOf(list, list.length * 10);
        }
        list[list_pointer] = x;
        if (min_indexes_pointer < 0 || x < list[min_indexes[min_indexes_pointer]]) {
            min_indexes_pointer++;
            if (min_indexes_pointer == min_indexes.length) {
                min_indexes = Arrays.copyOf(min_indexes, min_indexes.length * 10);
            }
            min_indexes[min_indexes_pointer] = list_pointer;
        }
    }

    public void pop() {
        if (min_indexes[min_indexes_pointer] == list_pointer) {
            min_indexes_pointer--;
        }
        list_pointer--;
    }

    public int top() {
        return list[list_pointer];
    }

    public int getMin() {
        return list[min_indexes[min_indexes_pointer]];
    }
}
