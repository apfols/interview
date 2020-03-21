package interview1;


public class SwapNode {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    /**
     * Solution 1: Use recursive
     * time: O(n)
     */

//    public ListNode swapPairs(ListNode head) {
//        if (head == null || head.next == null)
//            return head;
//
//        ListNode result = head.next;
//        head.next = swapPairs(head.next.next);
//        result.next = head;
//        return result;
//    }


    /**
     * Solution 2: Iterate over each node
     * time: O(n)
     */
//    public ListNode swapPairs(ListNode head) {
//        if (head == null || head.next == null)
//            return head;
//
//        ListNode result = head.next;
//        head.next = result.next;
//        result.next = head;
//
//        ListNode ptr = result.next;
//
//        while (ptr.next != null && ptr.next.next != null) {
//            ListNode temp = ptr.next;
//            ptr.next = temp.next;
//            temp.next = ptr.next.next;
//            ptr.next.next = temp;
//
//            ptr = ptr.next.next;
//        }
//
//
//        return result;
//    }

    /**
     * Solution 3: Use dummy node to handle boundary condition
     * time: O(n)
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;
        dummy.next = head;

        while (ptr.next != null && ptr.next.next != null) {
            ListNode temp = ptr.next;
            ptr.next = temp.next;
            temp.next = ptr.next.next;
            ptr.next.next = temp;

            ptr = ptr.next.next;
        }

        return dummy.next;
    }
}
