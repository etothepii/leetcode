package earth.bermuda.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MinStackTest {

    @Test
    public void can_find_minimum_item_on_stack_1() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertEquals(-3, minStack.getMin());
        minStack.pop();
        assertEquals(0, minStack.top());
        assertEquals(-2, minStack.getMin());
    }

    @Test
    public void can_find_minimum_item_on_stack_100_000_times() {
        for (int iteration = 1; iteration <= 100_000; iteration++) {
            int steps = Math.max(20, (int)(Math.random() * 100_000 / iteration));
            MinStackHarness minStackHarness = new MinStackHarness();
            for (int step = 0; step < steps; step++) {
                double random = Math.random();
                if (random < .3) {
                    minStackHarness.push((int)(Math.random() * Integer.MAX_VALUE));
                }
                else if (random < .6) {
                    minStackHarness.push(-(int)(Math.random() * Integer.MAX_VALUE));
                }
                else if (random < .9) {
                    minStackHarness.pop();
                }
                else if (random < .95) {
                    minStackHarness.assertEqualityOfMin();
                }
                else {
                    minStackHarness.assertEqualityOfTop();
                }
            }
        }
    }

    @Test
    public void can_profile_100_000() {
        long target = 1;
        int min_count = 0;
        long time = 0;
        for (int iteration = 1; iteration <= 100_000; iteration++) {
            int steps = Math.max(20, (int)(Math.random() * 100_000 / iteration));
            MinStack minStack = new MinStack();
            for (int step = 0; step < steps; step++) {
                double random = Math.random();
                if (random < .3) {
                    minStack.push((int)(Math.random() * Integer.MAX_VALUE));
                }
                else if (random < .6) {
                    minStack.push(-(int)(Math.random() * Integer.MAX_VALUE));
                }
                else if (random < .9) {
                    minStack.pop();
                }
                else {
                    long start = System.nanoTime();
                    minStack.getMin();
                    time += System.nanoTime() - start;
                    min_count++;
                }
            }
        }
        double mean = ((double)time) / min_count;
        assertTrue(mean < target, mean + "ns < " + target + "ns");
    }
}

class MinStackHarness {

    private final ArrayList<String> commands = new ArrayList<String>();

    private final MinStack minStack;
    private final NaiveMinStack naiveMinStack;

    public MinStackHarness(MinStack minStack, NaiveMinStack naiveMinStack) {
        this.minStack = minStack;
        this.naiveMinStack = naiveMinStack;
    }

    public MinStackHarness() {
        this(new MinStack(), new NaiveMinStack());
    }

    public void push(int x) {
        minStack.push(x);
        naiveMinStack.push(x);
        commands.add(Integer.toString(x));
    }

    public void pop() {
        minStack.pop();
        naiveMinStack.pop();
        commands.add("POP");
    }

    public void assertEqualityOfTop() {
        int expected = naiveMinStack.top();
        int actual = minStack.top();
        assertEquals(expected, actual, String.format(
                "TOP %d != %d: %s", expected, actual, Arrays.toString(commands.toArray(new String[0]))));
    }

    public void assertEqualityOfMin() {
        int expected = naiveMinStack.getMin();
        int actual = minStack.getMin();
        assertEquals(expected, actual, String.format(
                "MIN %d != %d: %s", expected, actual, Arrays.toString(commands.toArray(new String[0]))));
    }
}

class NaiveMinStack {

    private final ArrayList<Integer> list = new ArrayList<>();

    public NaiveMinStack() { }

    public void push(int x) {
        list.add(x);
    }

    public void pop() {
        if (list.isEmpty()) {
            return;
        }
        list.remove(list.size() - 1);
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