package interview1;

import java.util.*;

/**
 * https://leetcode.com/problems/two-sum/
 * Basic Idea: iterate over the array
 * - select one element
 * - find the other element
 */
public class TwoSum {
    /**
     * Solution 1: find the other element by iterating over the array
     *  time complexity: O(n^2)
     *  space complexity: O(n)
     */

    /**
     *  Solution 2: sort the array, and find the other element by binary search
     *  - sort the array by using pair (value + index)
     *  -- time complexity: O(nlog(n))
     *  -- space complexity: O(n)
     *  - iterate over each element and found it's left: O(nlog(n))
     *  -- time complexity: O(nlog(n))
     *  -- space complexity: O(1)
     *
     *  in total:
     *  - time complexity: O(nlog(n))
     *  - space complexity: O(n)
     */


//    public int[] twoSum(int[] nums, int target) {
//        Pair<Integer, Integer>[] pairs = new Pair[nums.length]; //(index, value)
//        for (int i = 0; i < nums.length; i++) {
//            pairs[i] = new Pair<>(i, nums[i]);
//        }
//
//        Comparator<Pair<Integer, Integer>> comp = Comparator.comparing(Pair::getValue);
//
//        Arrays.sort(pairs, comp);
//
//        for (int i = 0; i < nums.length; i++) {
//            int a = pairs[i].getValue();
//            int b = target - a;
//
//            int result = Arrays.binarySearch(pairs, i+1, nums.length, new Pair<>(0, b), comp);
//            if (result >= 0)
//                return new int[] {pairs[i].getKey(), pairs[result].getKey()};
//        }
//
//        return null;
//    }

    /**
     * Solution 3:  Use HashMap to find the other element
     * - Construct a HashMap:
     * -- time complexity: O(n)
     * -- space complexity: O(n)
     * - For each element, try to find if the corresponding value is found
     * -- time complexity: O(n)
     * -- space complexity: O(1)
     */
//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, List<Integer>> indexMap = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int key = nums[i];
//            if (!indexMap.containsKey(key))
//                indexMap.put(key, new ArrayList<>());
//            indexMap.get(nums[i]).add(i);
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            int a = nums[i];
//            int b = target - a;
//            List<Integer> indexList = indexMap.get(b);
//            if (indexList != null) {
//                for (Integer each: indexList) {
//                    if (each != i)
//                        return new int[] {i, each};
//                }
//            }
//        }
//
//        return null;
//    }

    /**
     * Solution 4: Optimization of Solution 3 by constructing HashMap and find element at the same time
     * - time complexity: O(n)
     * - space complexity: O(n)
     */

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int left = target - current;
            if (map.containsKey(left)) {
                return new int[]{map.get(left), i};
            }

            map.put(current, i);
        }
        return new int[0];
    }


    public static void main(String[] args) {
        TwoSum s = new TwoSum();
        System.out.println(Arrays.toString(s.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(s.twoSum(new int[]{3, 3}, 6)));

    }
}
