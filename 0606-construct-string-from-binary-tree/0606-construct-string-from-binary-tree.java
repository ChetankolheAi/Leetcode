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
    StringBuilder sb = new StringBuilder();
    public void Solve(TreeNode root){
        if(root==null)return;
        
        sb.append(String.valueOf(root.val));
        if(root.left==null && root.right==null) return;
        sb.append('(');
        Solve(root.left);
        sb.append(')');
        if(root.right==null) return;
        sb.append('(');
        Solve(root.right);
        sb.append(')');
        return ;

    }
    public String tree2str(TreeNode root) {
        Solve(root);
        return sb.toString();
    }
}