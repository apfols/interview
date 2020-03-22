package tree;


/**
 * https://leetcode.com/problems/binary-tree-pruning/
 */
public class BinaryTreePruning {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Solution:
     *  - try to do pruneTree on left subtree and right subtree first
     *  - if current node is a leaf and value is zero, return null (remove), else keep
     *
     *  time: O(n)
     */
    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        return root.left == null && root.right == null && root.val == 0
                ? null : root;
    }


}
