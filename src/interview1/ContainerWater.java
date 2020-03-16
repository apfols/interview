package interview1;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWater {

    /**
     *  Solution 1: Brute force
     *  For each of two bars, calculate the water and find the two bars with most water.
     *
     *  - time: O(n^2)
     *
     */
//    public int maxArea(int[] height) {
//        if (height == null || height.length < 2)
//            return 0;
//
//        int max = 0;
//        for (int start = 0; start < height.length - 1; start++) {
//            for (int end = start + 1; end < height.length; end++) {
//                int h = Math.min(height[start], height[end]);
//                int w = end - start;
//                int area = h * w;
//
//                if (max < area)
//                    max = area;
//            }
//        }
//
//        return max;
//    }

    /**
     * Solution 2: two pointer.
     * 1. declare two pointers from left most and right most
     * 2. more the pointer with shorter bar to close to other bar and calculate the area
     * <p>
     * time: O(n)
     */
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;

        int maxA = 0;
        while (start < end) {
            int startH = height[start];
            int endH = height[end];
            if (startH > endH) {
                int currentArea = endH * (end - start);
                if (currentArea > maxA)
                    maxA = currentArea;

                end--;
            } else if (startH < endH) {
                int currentArea = startH * (end - start);
                if (currentArea > maxA)
                    maxA = currentArea;

                start++;
            } else {
                int currentArea = startH * (end - start);
                if (currentArea > maxA)
                    maxA = currentArea;
                start++;
                end--;
            }
        }
        return maxA;
    }

    public static void main(String[] args) {
        ContainerWater c = new ContainerWater();
        System.out.println(c.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
