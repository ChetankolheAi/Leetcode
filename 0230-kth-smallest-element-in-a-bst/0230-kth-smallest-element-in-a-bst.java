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
    public int count;
    public int kthSmallest =-1;
    public void inorder(TreeNode root )
    {
        if (root == null) return;

        inorder(root.left);

        count--;
        if (count == 0) {
            kthSmallest = root.val;
            return; 
        }

        if (count > 0) {
            inorder(root.right);
        }
        


    }
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);

        return kthSmallest;
    }
}