package array;

public class FindMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 1;

        // swap value to destination index
        for (int i = 0; i < nums.length; i++) {
            int current = -1;
            int index = i;

            do {
                int nextIndex = nums[index] - 1;
                if (nextIndex == index)
                    break;

                nums[index] = current;
                index = nextIndex;
                current = index + 1;
            } while (index >= 0 && index < nums.length);
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
        System.out.println(f.firstMissingPositive(new int[] {3, 4, -1, 1}));
        System.out.println(f.firstMissingPositive(new int[] {7, 8, 9, 11, 12}));
    }
}
