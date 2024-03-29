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
    
    private int diameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);        
        return this.diameter;
    }
    
    private int longestPath(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int left = longestPath(node.left);
        int right = longestPath(node.right);
        
        this.diameter = Math.max(this.diameter, left + right);
        
        return Math.max(left, right) + 1;
    }
}