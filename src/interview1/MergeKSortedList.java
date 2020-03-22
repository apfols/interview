package interview1;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Solution: Use heap to store all pointers of list
     * NOTE:
     * - null list cannot be put in heap
     * - need to implement comparator
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode each : lists) {
            if (each != null)
                heap.add(each);
        }

        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;

        while (heap.size() > 1) {
            ListNode current = heap.remove();
            if (current.next != null)
                heap.add(current.next);

            ptr.next = current;
            ptr = ptr.next;
        }

        if (heap.size() == 1)
            ptr.next = heap.remove();

        return dummy.next;
    }
}
