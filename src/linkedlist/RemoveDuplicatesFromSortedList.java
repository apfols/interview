package linkedlist;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicatesFromSortedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /**
     * Solution: iterate over the list, if there is any duplicates, remove it.
     *
     * time: O(n)
     * space: O(1)
     *
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ptr = dummy;

        while (ptr.next != null) {
            // end of list, return the list directly
            if (ptr.next.next == null)
                break;

            // ptr.next is not duplicates, move forward pointer
            if (ptr.next.next.val != ptr.next.val) {
                ptr = ptr.next;
                continue;
            }

            // ptr.next has duplicates, find the next node whose value is not equal to ptr.next.val
            // since the found value may have duplicates, do not move forward pointer
            ListNode removePtr = ptr.next.next;
            while (removePtr != null && removePtr.val == ptr.next.val)
                removePtr = removePtr.next;

            ptr.next = removePtr;
        }

        return dummy.next;
    }
}
