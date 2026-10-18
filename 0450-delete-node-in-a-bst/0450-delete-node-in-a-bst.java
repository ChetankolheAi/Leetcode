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
        
        //Case 1 : Deleting Node have no child ( Leaf Node ) ;
        else if(key == root.val && root.right == null && root.left == null) return null;

        //Case 2 : Deleting Node have one child ;
        else if(key == root.val && root.right == null && root.left != null) return root.left;
        else if(key == root.val && root.right != null && root.left == null) return root.right;

        TreeNode leftSubtree = DeleteinorderSuccessor(root.left , key);
        root.left = leftSubtree;
        TreeNode rightSubtree = DeleteinorderSuccessor(root.right , key);
        root.right = rightSubtree;

        return root;

    }
    public int FindinorderSuccessor(TreeNode root , int key){
        
        if(root.left==null) return root.val;

        int x = FindinorderSuccessor(root.left , key);
        
        return x;

    }
    public TreeNode Solve(TreeNode root , int key ){
        
        if(root==null) return null;
        
        //Case 1 : Deleting Node have no child ( Leaf Node ) ;
        else if(key == root.val && root.right == null && root.left == null) return null;

        //Case 2 : Deleting Node have one child ;
        else if(key == root.val && root.right == null && root.left != null) return root.left;
        else if(key == root.val && root.right != null && root.left == null) return root.right;
        
        //Case 3 : Deleting Node has 2 Child 
        else if(key == root.val && root.right != null && root.left != null){

            //As the BST values are Unique we first find the inorderSuccessor
            //which lies in right subtree's Leftmost node is the inordersuccesor
            root.val = FindinorderSuccessor(root.right , key);

            //After the the inorder Succssor is Deleted here
            //1.Successor will have either 1 child or no child 
            TreeNode DeletedNodeSubtree = DeleteinorderSuccessor(root.right , root.val);

            root.right = DeletedNodeSubtree;
            return root;
        }
        else if(root.right == null && root.left == null){
            return root;
        }
        TreeNode leftSubtree = Solve(root.left , key);
        root.left = leftSubtree;
        TreeNode rightSubtree = Solve(root.right , key);
        root.right = rightSubtree;

        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        return Solve(root , key);
    }
}