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
    public int  Solve(TreeNode root , int low  , int high){
        
        if(root==null) return 0;

        int crrVal = 0;

        if(root.val >= low && root.val <= high) crrVal = root.val;

        int l = Solve(root.left ,low , high); 
        int r = Solve(root.right ,low , high );
        
        return l + r + crrVal;

    }
    public int rangeSumBST(TreeNode root, int low, int high) {
  
        return Solve(root,low , high);
        
    }
}