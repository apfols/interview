package interview1;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

    /**
     * Solution: Two pointer
     * Use to 2 pointers from left and right
     *   - move lower pointer forward until next height is higher than previous one and count the water can be stored
     *
     * time: O(n)
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int left = 0;
        int right = height.length - 1;
        int water = 0;

        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];

            if (leftHeight < rightHeight) {
                while (++left < right && height[left] <= leftHeight)
                    water += leftHeight - height[left];
            } else {
                while (--right > left && height[right] <= rightHeight)
                    water += rightHeight - height[right];
            }
        }

        return water;
    }



    public static void main(String[] args) {
        TrappingRainWater w = new TrappingRainWater();
        System.out.println(w.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(w.trap(new int[] {5,5,1,7,1,1,5,2,7,6}));
    }
}
