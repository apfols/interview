package interview1;

/**
 * https://leetcode.com/problems/maximum-binary-tree/
 */
public class MaxBinaryTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     * Solution 1: add each node to tree incrementally
     *
     * time: O(n^2)
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        TreeNode head = new TreeNode(nums[0]);

        if (nums.length == 1)
            return head;

        for (int i = 1; i < nums.length; i++) {
            head = insert(head, nums[i]);
        }

        return head;
    }

    public TreeNode insert(TreeNode head, int value) {
        if (value > head.val) {
            TreeNode current = new TreeNode(value);
            current.left = head;
            return current;
        } else {
            head.right = head.right == null ? new TreeNode(value) : insert(head.right, value);
            return head;
        }
    }


    /**
     * Solution 2:
     *  - find max value in the array
     *  - construct left tree
     *  - construct right tree
     *
     * time: O(n^2)
     *
     */
//    public TreeNode constructMaximumBinaryTree(int[] nums) {
//        return constructMaxBinaryTree(nums, 0, nums.length);
//    }
//
//    public TreeNode constructMaxBinaryTree(int[] nums, int start, int end) {
//        if (end - start <= 0)
//            return null;
//
//        if (end - start == 1)
//            return new TreeNode(nums[start]);
//
//        int max = Integer.MIN_VALUE;
//        int maxIndex = -1;
//        for (int i = start; i < end; i++) {
//            int current = nums[i];
//            if (current > max) {
//                max = current;
//                maxIndex = i;
//            }
//        }
//
//        TreeNode head = new TreeNode(nums[maxIndex]);
//        head.left = constructMaxBinaryTree(nums, start, maxIndex);
//        head.right = constructMaxBinaryTree(nums, maxIndex + 1, end);
//        return head;
//    }
//
//    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
//
//        if (root == null)
//            return new TreeNode(val);
//
//        if (val > root.val) {
//            TreeNode node = new TreeNode(val);
//            node.left = root;
//            return node;
//        }
//
//        root.right = root.right == null ? new TreeNode(val) : insertIntoMaxTree(root.right, val);
//
//        return root;
//    }


}
