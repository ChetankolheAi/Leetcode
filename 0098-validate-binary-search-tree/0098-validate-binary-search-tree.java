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
    public void inOrderTraversal(TreeNode root , List<Integer> li){
        if(root==null)return;

        inOrderTraversal(root.left,li);
        li.add(root.val);
        inOrderTraversal(root.right,li);
        
        return;

    }
    public boolean isValidBST(TreeNode root) {
        List<Integer>li = new ArrayList<>();
        inOrderTraversal(root,li);
        for(int i=0;i<li.size()-1;i++){
            if(li.get(i)>=li.get(i+1)){
                return false;
            }
        }
        return true;
    }
}