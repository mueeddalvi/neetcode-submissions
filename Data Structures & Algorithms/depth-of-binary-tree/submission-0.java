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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return traverse(root);
        
    }

    public int traverse(TreeNode root){
        if(root==null){
            return 0;
        }

        int left= 1+traverse(root.left);
        int right =1+traverse(root.right);

        return Math.max(left,right);
    }
}
