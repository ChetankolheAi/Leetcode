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
     int postIndex; 
    public TreeNode Solve( Map<Integer,Integer>map , int left , int right ,int[] inorder,int[] postorder){
        if(left>right) return null;
       
        TreeNode Newroot = new TreeNode(postorder[postIndex--]);
        int Index = map.get(Newroot.val);

        Newroot.right = Solve( map ,Index+1 , right, inorder , postorder);
        Newroot.left = Solve( map ,left , Index-1, inorder , postorder);

        return Newroot;
        
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer>map = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
         postIndex = postorder.length - 1;
        return Solve(map,0,inorder.length-1,inorder, postorder );

       
    }
}