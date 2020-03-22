package interview1;

import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 *
 * Solution: Use stack to do reverse
 */
public class ReverseKGroup {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Solution 1: Use stack.
     * - put every k elements in stack and get it out
     *
     * time: O(n)
     * space: O(k)
     */
//    public ListNode reverseKGroup(ListNode head, int k) {
//        if (k <= 1 || head == null)
//            return head;
//
//        Stack<ListNode> stack = new Stack<>();
//        ListNode ptr = head;
//        ListNode dummy = new ListNode(0);
//        ListNode prev = dummy;
//        while (ptr != null) {
//            while (ptr != null && stack.size() < k) {
//                stack.push(ptr);
//                ptr = ptr.next;
//            }
//
//            if (stack.size() < k)
//                break;
//
//            while (!stack.isEmpty()){
//                prev.next = stack.pop();
//                prev = prev.next;
//            }
//
//            prev.next = ptr;
//        }
//
//        return dummy.next;
//    }


    /**
     * Solution 2: Without stack.
     * - count if number is larger than k
     * - do reverse directly
     *
     * time: O(n)
     * extra space: O(1)
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null)
            return head;

        Stack<ListNode> stack = new Stack<>();
        ListNode ptr = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (ptr != null) {

            // check if left length is larger than k
            int count = 0;
            while (ptr != null && count++ < k) {
                ptr = ptr.next;
            }

            if (count < k)
                break;

            // reverse node link
            ListNode current = prev.next;
            ListNode next = current.next;
            for (int i = 0; i < k - 1; i++) {
                ListNode tempNext = next.next;
                next.next = current;
                current = next;
                next = tempNext;
            }


            ListNode tempPrev = prev.next;
            // update end node to rest lists
            prev.next.next = ptr;
            // update next node to the reverse link head
            prev.next = current;
            // update prev pointer
            prev = tempPrev;
        }

        return dummy.next;
    }
}
