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
        if(root==null){
             TreeNode newNode = new TreeNode(val);
             return newNode;
        }
        if(val>root.val){
            if(root.right==null){
                TreeNode newNode = new TreeNode(val);
                root.right = newNode;
                return root;
            }
            else{
                Solve(root.right,val);
            }
        }
        if(val<root.val){
            if(root.left==null){
                TreeNode newNode = new TreeNode(val);
                root.left = newNode;
                return root;
            }
            else{
                Solve(root.left,val);
            }
        }
        return root;
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return Solve(root,val);
    }
}