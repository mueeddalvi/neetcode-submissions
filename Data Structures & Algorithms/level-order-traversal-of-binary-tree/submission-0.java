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

    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) { 

        res=new ArrayList<>();

        dfs(root,0);
        
        return res;
    }

    void dfs(TreeNode root, int i){
        if(root==null)
            return;
        else{
            if(res.size()<=i)
                res.add(i,new ArrayList<>());
            res.get(i).add(root.val);
            dfs(root.left, i+1);
            dfs(root.right,i+1);
        }
    }
}
