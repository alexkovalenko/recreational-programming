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
    public List<Integer> preorderTraversal(TreeNode node) {
        if (node == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        
        result.add(node.val);
        
        if(node.left != null) {
            result.addAll(preorderTraversal(node.left));
        }
        if(node.right != null) {
            result.addAll(preorderTraversal(node.right));
        }
        return result;
    }
}