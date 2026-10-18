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
    public TreeNode DeleteinorderSuccessor(TreeNode root , int key){
        if(root==null) return null;
        if(key == root.val && root.right == null && root.left == null){
            return null;
        }
        else if(key == root.val && root.right == null && root.left != null){
            return root.left;
        }
        else if(key == root.val && root.right != null && root.left == null){
            return root.right;
        }
        TreeNode l = DeleteinorderSuccessor(root.left , key);
        root.left = l;
        TreeNode r = DeleteinorderSuccessor(root.right , key);
        root.right = r;

        return root;

    }
    public int FindinorderSuccessor(TreeNode root , int key){
        if(root.left==null){
            return root.val;
        }
        int x = FindinorderSuccessor(root.left , key);
        return x;
    }
    public TreeNode Solve(TreeNode root , int key ){
        if(root==null) return null;
        if(key == root.val && root.right == null && root.left == null){
            return null;
        }
        else if(key == root.val && root.right == null && root.left != null){
            return root.left;
        }
        else if(key == root.val && root.right != null && root.left == null){
            return root.right;
        }
        else if(key == root.val && root.right != null && root.left != null){
            root.val = FindinorderSuccessor(root.right , key);
            TreeNode y = DeleteinorderSuccessor(root.right,root.val);
            root.right = y;
            return root;
        }
        else if(root.right == null && root.left == null){
            return root;
        }
        TreeNode l = Solve(root.left , key);
        root.left = l;
        TreeNode r = Solve(root.right , key);
        root.right = r;

        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        return Solve(root , key);
    }
}