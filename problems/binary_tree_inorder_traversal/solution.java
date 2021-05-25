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
    public List<Integer> inorderTraversal(TreeNode node) {
        if(node == null) {
            return new ArrayList<Integer>();
        }
        
        List<Integer> result = new ArrayList<>();
        
        if(node.left != null) {
            result.addAll(inorderTraversal(node.left));
        }
        
        result.add(node.val);
        
        if(node.right != null) {
            result.addAll(inorderTraversal(node.right));
        }
        
        return result;
    }
}