package interview1;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
public class RotatedSearchArrayII {
    /**
     * Solution 1: iterate over all arrays
     *  - if target is found, return true
     *  - if target does not exists in arrays, return false
     *
     *  time: O(n)
     */
//    public boolean search(int[] nums, int target) {
//        for (int each: nums) {
//            if (each == target)
//                return true;
//        }
//        return false;
//    }


    /**
     * Solution 2: Use divide and conquer.
     * - if value of start is less than value of end, it means it's a sorted array => use binary search
     * - check if it's in the first half array or in the second half array
     *
     * time:
     *   average case: O(log(n))
     *   worse case: O(n)
     */
    public boolean search(int[] nums, int target) {
        return nums != null && nums.length != 0 && search(nums, 0, nums.length, target);
    }

    public boolean search(int[] nums, int start, int end, int target) {
        if (end - start == 1)
            return nums[start] == target;

        if (nums[start] < nums[end - 1]) {
            return  target >= nums[start]
                        && target <= nums[end - 1]
                        && Arrays.binarySearch(nums, start, end, target) >= 0;
        } else {
            int mid = (start + end) / 2;
            return search(nums, start, mid, target) || search(nums, mid, end, target);
        }
    }


//    public boolean search(int[] nums, int target) {
//        return nums != null && nums.length != 0 && search(nums, 0, nums.length, target);
//    }
//
////    public boolean search(int[] nums, int start, int end, int target) {
////        if (end - start == 1)
////            return nums[start] == target;
////
////        // 1, 3, 1,1,1
////        if (nums[start] < nums[end - 1])
////            return Arrays.binarySearch(nums, start, end, target) >= 0;
////
////        int mid = (start + end) / 2;
////
////        return search(nums, start, mid, target) || search(nums, mid, end, target);
////    }
//
//    public boolean search(int[] nums, int start, int end, int target) {
//        if (end - start == 1)
//            return nums[start] == target;
//
//        // 1, 3, 1,1,1
//        if (nums[start] < nums[end - 1])
//            return Arrays.binarySearch(nums, start, end, target) >= 0;
//
//        int mid = (start + end) / 2;
//        if (target == nums[mid - 1] || target == nums[start] || target == nums[end - 1])
//            return true;
//
//        if (nums[start] < nums[mid - 1]) {
//            if (target > nums[mid - 1] || target < nums[start])
//                return search(nums, mid, end, target);
//            else
//                return Arrays.binarySearch(nums, start, mid, target) >= 0;
//        } else if (nums[mid] < nums[end - 1]) {
//            if (target > nums[end - 1] || target < nums[mid])
//                return search(nums, start, mid, target);
//            else
//                return Arrays.binarySearch(nums, mid, end, target) >= 0;
//        } else {
//            return search(nums, start, mid, target) || search(nums, mid, end, target);
//        }
//    }

//    public boolean search(int[] nums, int target) {
//        if (nums == null || nums.length == 0)
//            return false;
//
//        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
//        queue.add(new Pair<>(0, nums.length));
//
//        while (!queue.isEmpty()) {
//            Pair<Integer, Integer> p = queue.remove();
//            int startIndex = p.getKey();
//            int endIndex = p.getValue();
//
//            if (endIndex - startIndex <= 0)
//                continue;
//
//            if (endIndex - startIndex == 1)
//                if (nums[startIndex] == target)
//                    return true;
//                else
//                    continue;
//
//            int left = nums[startIndex];
//            int right = nums[endIndex - 1];
//
//            if (left < right) {
//                if (target >= left && target <= right)
//                    return Arrays.binarySearch(nums, startIndex, endIndex, target) >= 0;
//                else
//                    continue;
//            } else if (left > right) {
//                if (target >= left || target <= right) {
//                    queue.clear();
//                } else {
//                    continue;
//                }
//            }
//
//            // left == right || (left > right & target in current range)
//            int mid = (startIndex + endIndex) / 2;
//            queue.add(new Pair<>(startIndex, mid));
//            queue.add(new Pair<>(mid, endIndex));
//        }
//
//        return false;
//    }

    public static void main(String[] args) {
        RotatedSearchArrayII r = new RotatedSearchArrayII();
//        System.out.println(r.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
//        System.out.println(r.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
        System.out.println(r.search(new int[]{1, 3, 1, 1, 1, 1, 1}, 3));
//        System.out.println(r.search(new int[]{1}, 0));


    }
}
