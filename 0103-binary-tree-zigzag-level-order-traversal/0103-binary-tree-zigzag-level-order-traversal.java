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
    public List<List<Integer>> BFS(TreeNode root) {
        List<List<Integer>>li = new ArrayList<>();
if (root == null) return li;
    Queue<TreeNode> q = new LinkedList<>();

    q.offer(root);
    boolean isEven = false;
    while (!q.isEmpty()) {

        int size = q.size();
        List<Integer>l1 = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            
            TreeNode curr = q.poll();
            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
            
            l1.add(curr.val);
        }
        if(isEven) Collections.reverse(l1);
        
        isEven = !isEven;
        li.add(l1);
    }
    return li;
}
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return BFS(root);
    }
}