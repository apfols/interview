package interview1;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class RotatedSortedArray {
    /**
     * Solution:
     * Use something similar to binary search
     * - if the current half array is sorted array, and value is within the array => use binary search.
     * - if the current half array is rotated sorted array, keep doing divide and conquer
     *
     * since every will reduce half number of array
     * time: O(log(n))
     */

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        return search(nums, 0, nums.length, target);
    }

    public int search(int[] nums, int start, int end, int target) {
        if (end - start == 1) {
            return nums[start] == target ? start : -1;
        }

        if (nums[start] < nums[end - 1]) {
            if (target >= nums[start] && target <= nums[end - 1]) {
                int result = Arrays.binarySearch(nums, start, end, target);
                return result >= 0 ? result : -1;
            } else {
                return -1;
            }
        }

        if (target < nums[start] && target > nums[end - 1])
            return -1;

        int mid = (start + end) / 2;
        int first = search(nums, start, mid, target);
        return first >= 0 ? first : search(nums, mid, end, target);
    }


    public static void main(String[] args) {
        RotatedSortedArray r = new RotatedSortedArray();
        System.out.println(r.search(new int[] {4,5,6,7,0,1,2}, 0));
        System.out.println(r.search(new int[] {4,5,6,7,0,1,2}, 3));
        System.out.println(r.search(new int[] {3, 4, 5, 6, 1, 2}, 2));

    }
}
