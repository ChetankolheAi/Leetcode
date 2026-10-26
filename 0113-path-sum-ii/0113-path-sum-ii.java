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
    public void Solve(List<List<Integer>>ans,List<Integer>temp,TreeNode root , int target , int sum){
            if(root==null)return;
            sum+=root.val;
            temp.add(root.val);
            if(root.left==null && root.right==null && sum == target){
                ans.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
                return ;
            }
            else if(root.left==null && root.right==null){
                temp.remove(temp.size() - 1);
                return;
            }
            Solve(ans , temp , root.left , target , sum);
            Solve(ans , temp , root.right , target , sum);
            
            //System.out.println(sum+","+root.val);
            temp.remove(temp.size()-1);

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer>temp = new ArrayList<>();
        Solve(ans ,temp,root,targetSum , 0 );
        return ans;
    }
}