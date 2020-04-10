package earth.bermuda.leetcode;

import java.util.ArrayList;

public class MinStack {

    private final ArrayList<Integer> list = new ArrayList<>();

    public MinStack() {

    }

    public void push(int x) {
        list.add(x);
    }

    public void pop() {
        if (list.isEmpty()) {
            return;
        }
        list.remove(list.size() -1);
    }

    public int top() {
        if (list.isEmpty()) {
            return 0;
        }
        return list.get(list.size() - 1);
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int i : list) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }
}
