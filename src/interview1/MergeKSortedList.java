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
     * Solution 1: Use heap to store all pointers of list
     * NOTE:
     * - null list cannot be put in heap
     * - need to implement comparator
     *
     * time: O(nlog(k))
     *   assume nodes in total, k lists
     * space: O(k)
     */
//    public ListNode mergeKLists(ListNode[] lists) {
//        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
//        for (ListNode each : lists) {
//            if (each != null)
//                heap.add(each);
//        }
//
//        ListNode dummy = new ListNode(0);
//        ListNode ptr = dummy;
//
//        while (heap.size() > 1) {
//            ListNode current = heap.remove();
//            if (current.next != null)
//                heap.add(current.next);
//
//            ptr.next = current;
//            ptr = ptr.next;
//        }
//
//        if (heap.size() == 1)
//            ptr.next = heap.remove();
//
//        return dummy.next;
//    }


    /**
     * Solution 2: Divide and conquer
     * Note:
     *   - lists may be null or empty
     *
     * - implement merge 2 two list algorithm
     * - for each 2 two lists, merge it and put the new list to the original list array
     * - after several iterations, there will be only one list
     *
     * time: O(nlog(k))
     * space: O(1)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return lists == null || lists.length == 0 ? null : mergeKList(lists, lists.length);
    }

    public ListNode mergeKList(ListNode[] lists, int end) {
        if (end == 1)
            return lists[0];

        if (end == 2)
            return mergeTwoList(lists[0], lists[1]);

        int nextEnd = (end + 1) / 2;

        for (int i = 0; i < nextEnd; i++) {
            int l1 = i * 2;
            int l2 = l1 + 1;

            lists[i] = l2 < end ? mergeTwoList(lists[l1], lists[l2]) : lists[l1];
        }

        return mergeKList(lists, nextEnd);
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode l1Ptr = l1;
        ListNode l2Ptr = l2;
        ListNode ptr = dummy;

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

        ptr.next = l1Ptr == null ? l2Ptr : l1Ptr;
        return dummy.next;
    }
}
