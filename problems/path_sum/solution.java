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
    public boolean hasPathSum(TreeNode n, int targetSum) {
        if(n == null) {
            return false;
        } else if (n.left == null && n.right == null) {
            return targetSum == n.val;
        }
        
        return n.left != null && hasPathSum(n.left, targetSum - n.val) 
            || n.right != null &&hasPathSum(n.right, targetSum - n.val);
    }
}