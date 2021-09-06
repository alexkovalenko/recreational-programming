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
    public boolean hasPathSum(TreeNode n, int target) {
        if (n == null) {
            return false;
        }
        
        target -= n.val;
        
        if (n.left == null && n.right == null) {
            return target == 0;
        }
        
        return hasPathSum(n.left, target) || hasPathSum(n.right, target);
    }
}