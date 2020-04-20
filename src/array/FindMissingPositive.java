package array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/first-missing-positive/submissions/
 */
public class FindMissingPositive {
    /**
     * Solution 1: sort the given array
     * - iterate over the array, to find the missing positive number
     *
     * time: O(nlog(n))
     */
//    public int firstMissingPositive(int[] nums) {
//        Arrays.sort(nums);
//        int value = 1;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > value)
//                return value;
//            else if (nums[i] == value)
//                value++;
//            // if nums[i] < value, do nothing
//        }
//
//        return value;
//    }

    /**
     * Solution 2: use the original array to put the appropriate number
     * - iterate over the array
     *   - if the number is in valid range [1, array length]
     *     - keep swapping the valid number to the correct place (num[i] = i + 1) until all numbers are in the correct place
     *   - if the current index value is incorrect, set it to -1 (negative value)
     *
     * - iterate over the array again,
     *   - if negative value is found, return index + 1
     *   - if no negative value is found, means all elements in the array is filled in value: index + 1, so the missing value is length + 1
     *
     * time: O(n)
     */
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 1;

        // swap value to destination index
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];

            while (value > 0 && value < nums.length + 1 && nums[value - 1] != value) {
                int temp = nums[value - 1];
                nums[value - 1] = value;
                value = temp;
            }

            // after swap, if nums[i] does not have correct value, set it to -1
            if (nums[i] != i + 1)
                nums[i] = -1;
        }

        //if there is any element in the array less than 0, it's the smallest
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0)
                return i + 1;
        }

        //if not, the smallest integer is num.length + 1
        return nums.length + 1;
    }

    public static void main(String[] args) {
        FindMissingPositive f = new FindMissingPositive();
        System.out.println(f.firstMissingPositive(new int[] {1, 2, 0}));
        System.out.println(f.firstMissingPositive(new int[] {1, 2, 3}));
        System.out.println(f.firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(f.firstMissingPositive(new int[] {7, 8, 9, 11, 12}));
    }
}
