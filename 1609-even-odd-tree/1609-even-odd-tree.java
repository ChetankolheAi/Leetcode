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
    public boolean Solve(TreeNode root){


        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);      
        boolean isOdd = true;
        int prev = -1;

        while (!q.isEmpty()) {

            int size = q.size(); 
            for (int i = 0; i < size; i++) {
                
                TreeNode curr = q.poll();

                if( isOdd && curr.val%2==0  || ( isOdd && prev!=-1 && prev >= curr.val  ) ||
                  ( !isOdd && curr.val%2!=0 || ( !isOdd && prev!=-1 && prev <= curr.val ))) return false;
                   
                if (curr.left != null)
                    q.add(curr.left);

                if (curr.right != null)
                    q.add(curr.right);

                prev = curr.val;
            }
            isOdd = isOdd?false:true;
          
            prev = -1;
            
        }
        return true;

    }
    public boolean isEvenOddTree(TreeNode root) {
        return Solve(root);

    }
}