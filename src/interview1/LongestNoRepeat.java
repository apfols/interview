package interview1;

import java.util.*;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
 */
public class LongestNoRepeat {
    /**
     * Solution 1, Brute-force with HashSet
     * For each character, found its longest substring by using HashSet
     * - time: O(n^2)
     * - space: O(n)
     */
//    public int lengthOfLongestSubstring(String s) {
//        int max = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            HashSet<Character> set = new HashSet<>();
//            for (int j = i; j < s.length(); j++) {
//                Character currentChar = s.charAt(j);
//                if (set.contains(currentChar))
//                    break;
//
//                set.add(currentChar);
//            }
//
//            if (set.size() > max)
//                max = set.size();
//        }
//
//
//
//        return max;
//    }

    /**
     * Sliding window from beginning
     */
//    public int lengthOfLongestSubstring(String s) {
//        if (s == null || s.length() == 0)
//            return 0;
//
//        Map<Character, Queue<Integer>> indexMap = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            Character currentChar = s.charAt(i);
//            if (!indexMap.containsKey(currentChar))
//                indexMap.put(currentChar, new LinkedList<>());
//            indexMap.get(currentChar).add(i);
//        }
//
//        int[] length = new int[s.length()];
//        fillLength(length, indexMap, 0, s);
//        int max = 0;
//        for (int each : length) {
//            if (each > max)
//                max = each;
//        }
//
//        return max;
//    }
//
//    public void fillLength(int[] length, Map<Character, Queue<Integer>> indexMap, int index, String s) {
//        if (index == s.length() - 1) {
//            length[index] = 1;
//            return;
//        }
//
//        int nextDuplicateIndex = findNextIndex(indexMap, s.charAt(index));
//        fillLength(length, indexMap, index + 1, s);
//        int nextElementRepeatLength = length[index + 1] + 1;
//
//        if (nextDuplicateIndex < 0) {
//            length[index] = nextElementRepeatLength;
//        } else {
//            length[index] = Math.min(nextDuplicateIndex - index, nextElementRepeatLength);
//        }
//    }
//
//    public int findNextIndex(Map<Character, Queue<Integer>> indexMap, Character c) {
//        Queue<Integer> queue = indexMap.get(c);
//        queue.remove();
//        return queue.isEmpty() ? -1 : queue.peek();
//    }


    /**
     * Solution 2: Sliding window. Use HashMap to find previous character.
     *
     *
     * 1. For each character in the string
     *    - if never occurs or not in current sliding window, just update HashMap
     *    - if it occurs in current sliding window,
     *      - see if need to update max length
     *      - update sliding window
     *
     * 2. Check the rest of the string to see if need to update max length
     *
     * Time: O(n)
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            if (map.containsKey(current)) {
                int prev = map.get(current);
                //NOTE: only need to update when the existing index is equal to or after start
                if (prev >= start) {
                    int length = i - 1 - start + 1;
                    if (max < length)
                        max = length;

                    start = map.get(current) + 1;
                }
            }

            map.put(current, i);
        }

        //NOTE: Don't forget if there is no duplicates after
        int length = s.length() - 1 - start + 1;
        if (max < length)
            max = length;

        return max;
    }


        public static void main(String[] args) {
        LongestNoRepeat l = new LongestNoRepeat();
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(l.lengthOfLongestSubstring("bbbbb"));
        System.out.println(l.lengthOfLongestSubstring("pwwkew"));
        System.out.println(l.lengthOfLongestSubstring("abcdef"));
        System.out.println(l.lengthOfLongestSubstring(" "));
        System.out.println(l.lengthOfLongestSubstring("aab"));
        System.out.println(l.lengthOfLongestSubstring("abba"));
    }
}
