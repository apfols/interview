package interview1;

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 *
 *
 */
public class ThreeSum {
    /**
     * Solution 1:
     * Assume there are M elements int the result
     * Basic idea
     * 1. use tree set to distinct result
     * 2. use 2 for loop to find the first two element and try to find if the 3 element exists
     *
     * Algorithm
     * 1. implement TreeSet Comparator
     * 2. iterate over all array to construct a HashMap to look up index:
     *    - time: O(n)
     *    - space: O(n)
     *
     * 2. iterate over 2D for loop (* n^2)
     *    - find the target 3rd element
     *      - time: O(1)
     *    - sort result list: O(1)
     *    - add to tree set (mlog(m))
     *
     * In total:
     *   - time: O(n^2 * mlog(m))
     *   - space: O(n)
     */

//    public List<List<Integer>> threeSum(int[] nums) {
//        if (nums == null || nums.length < 3)
//            return Collections.emptyList();
//
//        HashMap<Integer, Integer> indexMap = new HashMap<>(); //number, index
//
//        for (int i = 0; i < nums.length; i++) {
//            indexMap.put(nums[i], i);
//        }
//
//        TreeSet<List<Integer>> result = new TreeSet<>((o1, o2) -> {
//            if (o1.size() > o2.size())
//                return 1;
//            if (o1.size() < o2.size())
//                return -1;
//
//            for (int i = 0; i < o1.size(); i++) {
//                int compare = o1.get(i).compareTo(o2.get(i));
//                if (compare != 0)
//                    return compare;
//            }
//
//            return 0;
//        });
//
//        for (int i = 0; i < nums.length - 2; i++) {
//            for (int j = i + 1; j < nums.length -1; j++) {
//                int n1 = nums[i];
//                int n2 = nums[j];
//                int left = - n1 - n2;
//
//                Integer leftIndex = indexMap.get(left);
//                if (leftIndex != null && leftIndex != i && leftIndex != j) {
//                    List<Integer> list = Arrays.asList(nums[i], nums[j], left);
//                    Collections.sort(list);
//                    result.add(list);
//                }
//            }
//        }
//
//        return new ArrayList<>(result);
//    }


    /**
     * Solution 2: Optimize Solution 1 by counting elements
     * Since we do not need index, we only need to count number of elements to ensure there are enough elements to be used.
     *
     * Algorithm:
     * 1. iterate over the arrays to construct count map
     *   - time: O(n)
     *   - space: O(n)
     * 2. iterate over the count map twice since count may larger than 1 (* N^2)
     *   - time: O(n)
     * in total:
     *   - time: O(n^2)
     *   - space: O(n)
     *
     */
//    public List<List<Integer>> threeSum(int[] nums) {
//        if (nums == null || nums.length < 3)
//            return Collections.emptyList();
//
//        HashMap<Integer, Integer> countMap = new HashMap<>();
//        for (int each: nums) {
//            int count = countMap.getOrDefault(each, 0);
//            countMap.put(each, count + 1);
//        }
//
//        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(countMap.entrySet());
//        ArrayList<List<Integer>> result = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = i; j < list.size(); j++) {
//                int n1 = list.get(i).getKey();
//                int n2 = list.get(j).getKey();
//
//                if (n1 == n2 && list.get(j).getValue() < 2)
//                    continue;
//
//                int left = - n1 - n2;
//
//                Integer leftCount = countMap.get(left);
//                if (leftCount == null)
//                    continue;
//
//                if (n1 == n2) {
//                    if (n1 == left && leftCount < 3)
//                        continue;
//                } else {
//                    if ((n1 == left || n2 == left) && leftCount < 2)
//                        continue;
//                }
//
//                if (left < n1 || left < n2)
//                    continue;
//
//                result.add(Arrays.asList(n1, n2, left));
//            }
//        }
//
//        return result;
//    }

//    public List<List<Integer>> threeSum(int[] nums) {
//
//
//
//    }

//    class Solution {
//        public List<List<Integer>> threeSum(int[] nums) {
//            if (nums.length < 3)
//                return Collections.emptyList();
//
//            HashMap<Integer, Integer> countMap = new HashMap<>();
//            for (int each: nums)
//                countMap.put(each, countMap.getOrDefault(each, 0));
//
//            Arrays.sort(nums);
//            List<List<Integer>> result = new ArrayList<>();
//
//            int left = 0;
//            int right = nums.length - 1;
//
//            while (left < right - 1) {
//                int one = nums[left];
//                int nextLeft = left + 1;
//                int nextRight = right;
//                while (nextLeft < nextRight) {
//                    int two = nums[nextLeft];
//                    int three = - one - two;
//                    int index = Arrays.binarySearch(nums, nextLeft + 1, right + 1, three);
//
//                    if (index > nextLeft) {
//                        if (left + 1 == nextLeft)
//                            right = index;
//
//                        nextRight = index;
//                        result.add(Arrays.asList(one, two, three));
//                    }
//
//                    while (++nextLeft < right && nums[nextLeft] == two);
//                }
//
//                while (++left < right -1 && nums[left] == one);
//            }
//
//            return result;
//        }
//    }

//    public List<List<Integer>> threeSum(int[] nums) {
//        if (nums.length < 3)
//            return Collections.emptyList();
//
//        HashMap<Integer, Integer> countMap = new HashMap<>();
//        for (int each: nums)
//            countMap.put(each, countMap.getOrDefault(each, 0) + 1);
//
//        Integer[] values = countMap.keySet().toArray(new Integer[0]);
//        Arrays.sort(values);
//        List<List<Integer>> result = new ArrayList<>();
//
//        for (int i = 0; i < values.length; i++) {
//            int first = values[i];
//            int firstCount = countMap.get(first);
//            for (int j = i; j < values.length; j++) {
//                int second = values[j];
//
//                if (i == j && firstCount == 1)
//                    continue;
//
//                int target = -first - second;
//
//                if (target == 0 && first == 0 && second == 0) {
//                    if (firstCount >= 3)
//                        result.add(Arrays.asList(0, 0 , 0));
//
//                    continue;
//                }
//
//                int targetCount = countMap.getOrDefault(target, -1);
//                if (targetCount == -1)
//                    continue;
//
//                if (target == second && targetCount < 2)
//                    continue;
//
//                if (target < second)
//                    continue;
//
//                result.add(Arrays.asList(first, second, target));
//
//            }
//        }
//
//        return result;
//    }

//    public List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort(nums);
//        int left = 0;
//        int right = nums.length - 1;
//        List<List<Integer>> result = new ArrayList<>();
//        while (left < right) {
//            int rightValue = nums[right];
//            int rightMost = right;
//            while (left < rightMost) {
//                int leftValue = nums[left];
//                int target = - rightValue - leftValue;
//
//                int targetIndex = Arrays.binarySearch(nums, left + 1, right, target);
//                if (targetIndex > 0) {
//                    result.add(Arrays.asList(leftValue, rightValue, target));
//                    rightMost = targetIndex;
//                }
//
//                while (++left < rightMost && nums[left] == leftValue);
//            }
//
//            left = 0;
//            while (--right > left && nums[right] == rightValue);
//        }
//
//        return result;
//
//    }


    /**
     * Solution 3:
     *  1. sort the given array
     *     - time: O(nlog(n))
     *  2. for each element in the array as selected target (negative target) ( * N)
     *     - declare two pointers: (O(n))
     *       - Left pointer is the next element of selected value
     *       - Right pointer is the last element of the given array
     *     - if sum of the pointed element are larger than target
     *       move right pointer backward
     *     - if sum of the pointed element are less than target
     *       move left pointer forward
     *     - if the same => add to result
     *       and move left and right (to the DIFFERENT value)
     *
     *     - move the selected target to next DIFFERENT element
     *
     *  in total:
     *  - time complexity: O(n^2)
     */

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3)
            return Collections.emptyList();

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int index = 0;
        while (index < nums.length - 2) {
            int current = nums[index];
            int target = - current;
            int left = index + 1;
            int right = nums.length - 1;

            while (left < right) {
                int first = nums[left];
                int second = nums[right];
                int total = first + second;

                if (total == target) {
                    result.add(Arrays.asList(first, second, - target));

                    while (left < right && nums[left] == first)
                        left++;

                    while (left < right && nums[right] == second)
                        right--;

                } else if (total > target) {
                        right--;
                } else { //total < target
                        left++;
                }
            }

            while (++index < nums.length - 2 && nums[index] == current);
        }

        return result;
    }



    public static void main(String[] args) {
        ThreeSum s = new ThreeSum();
        System.out.println(s.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(s.threeSum(new int[]{-2,0,1,1,2}));
        System.out.println(s.threeSum(new int[]{0, 0, 0}));
    }
}
