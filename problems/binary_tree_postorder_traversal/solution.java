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
    public List<Integer> postorderTraversal(TreeNode node) {
        if(node == null) {
            return new ArrayList<Integer>();
        }
        
        List<Integer> result = new ArrayList<>();
        
        if(node.left != null) {
            result.addAll(postorderTraversal(node.left));
        }
        
        if(node.right != null) {
            result.addAll(postorderTraversal(node.right));
        }
        
        result.add(node.val);
        
        return result;
    }
}