package earth.bermuda.leetcode;

import java.util.List;

public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode me = this;
            sb.append(val);
            while ((me = me.next) != null) {
                sb.append(", ");
                sb.append(me.val);
            }
            return sb.toString();
        }
    }
}

