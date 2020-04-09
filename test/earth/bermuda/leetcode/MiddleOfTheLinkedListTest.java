package earth.bermuda.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MiddleOfTheLinkedListTest {

    private static MiddleOfTheLinkedList.ListNode[] getNode(int[] nums) {
        MiddleOfTheLinkedList.ListNode previous = null;
        MiddleOfTheLinkedList.ListNode[] nodes = new MiddleOfTheLinkedList.ListNode[nums.length];
        for (int i = nums.length - 1; i>= 0; i--) {
            MiddleOfTheLinkedList.ListNode node = new MiddleOfTheLinkedList.ListNode(nums[i]);
            node.next = previous;
            previous = node;
            nodes[i] = node;
        }
        return nodes;
    }

    @Test
    public void can_find_middle_element_1() {
        MiddleOfTheLinkedList.ListNode[] target = getNode(new int[] {1,2,3,4,5,6});
        MiddleOfTheLinkedList.ListNode expected = target[3];
        MiddleOfTheLinkedList.ListNode actual = new MiddleOfTheLinkedList().middleNode(target[0]);
        assertEquals(expected, actual, target[0].toString());
    }

    @Test
    public void can_find_middle_element_2() {
        MiddleOfTheLinkedList.ListNode[] target = getNode(new int[] {1});
        MiddleOfTheLinkedList.ListNode expected = target[0];
        MiddleOfTheLinkedList.ListNode actual = new MiddleOfTheLinkedList().middleNode(target[0]);
        assertEquals(expected, actual, target[0].toString());
    }

    @Test
    public void can_find_middle_element_3() {
        MiddleOfTheLinkedList.ListNode[] target = getNode(new int[] {1,2,3,4,5});
        MiddleOfTheLinkedList.ListNode expected = target[2];
        MiddleOfTheLinkedList.ListNode actual = new MiddleOfTheLinkedList().middleNode(target[0]);
        assertEquals(expected, actual, target[0].toString());
    }

    @Test
    public void can_find_middle_element_4() {
        MiddleOfTheLinkedList.ListNode[] target = getNode(new int[] {1,2,3,4,5,6,7,8,9,10});
        MiddleOfTheLinkedList.ListNode expected = target[5];
        MiddleOfTheLinkedList.ListNode actual = new MiddleOfTheLinkedList().middleNode(target[0]);
        assertEquals(expected, actual, target[0].toString());
    }

}