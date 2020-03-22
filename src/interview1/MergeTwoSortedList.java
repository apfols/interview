package interview1;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

    }

    /**
     * Solution:
     * - Create a dummy node to handle boundary condition
     * - Create 3 pointers
     *   * ptr to handle result list iteration
     *   * l1Ptr to handle l1 iteration
     *   * l2Ptr to handle l2 iteration
     * - create a while loop to move forward pointers (ptr, l1Ptr) or (ptr, l2Ptr) until l1Ptr or l2Ptr is null
     * - put rest of list to the end
     *
     * time: O(n)
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l1Ptr = l1;
        ListNode l2Ptr = l2;
        // create dummy node for boundary condition
        ListNode result = new ListNode(0);
        ListNode ptr = result;

        while (l1Ptr != null && l2Ptr != null) {
            if (l1Ptr.val < l2Ptr.val) {
                ptr.next = l1Ptr;
                l1Ptr = l1Ptr.next;
                ptr = ptr.next;
            } else {
                ptr.next = l2Ptr;
                l2Ptr = l2Ptr.next;
                ptr = ptr.next;
            }
        }

        if (l1Ptr == null) {
            ptr.next = l2Ptr;
        } else {
            ptr.next = l1Ptr;
        }

        return result.next;
    }
}
