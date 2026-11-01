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
    public TreeNode Solve(TreeNode root , int val){
        
        TreeNode newNode = new TreeNode(val);
       
        if(root==null) return newNode;
        
        if(val>root.val)
        {
            if(root.right==null) root.right = newNode;
            else Solve(root.right,val); 
        }
        if(val<root.val)
        {
            if(root.left==null) root.left = newNode;
            else Solve(root.left,val);
        }
        return root;
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return Solve(root,val);
    }
}