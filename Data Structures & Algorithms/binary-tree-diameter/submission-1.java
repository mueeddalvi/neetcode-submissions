/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        traverse(root);
        return res;
    }

    public int traverse(TreeNode root) {
        if (root == null)
            return 0;

        int left = traverse(root.left);
        int right = traverse(root.right);
        res = Math.max(res, left + right);
        return 1 + Math.max(left, right);
    }
}
