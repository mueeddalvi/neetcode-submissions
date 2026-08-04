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
    int res, count = 0;

    public int kthSmallest(TreeNode root, int k) {
        res = Integer.MIN_VALUE;

        dfs(root, k);

        return res;
    }

    public void dfs(TreeNode root, int k) {
        if (root == null)
            return;

        dfs(root.left, k);
        count++;
        if (k == count) {
            res = root.val;
            return;
        }

        dfs(root.right, k);
    }
}
