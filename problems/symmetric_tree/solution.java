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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        List<TreeNode> level = new ArrayList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n == null) {
                if (!isLevelSymmetric(level)) {
                    return false;
                }
                if (!q.isEmpty()) {
                    q.add(null);
                    level = new ArrayList<>();
                }    
            } else {
                level.add(n);
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
            }
        }
        return true;
    }
    
    private boolean isLevelSymmetric(List<TreeNode> level) {
        if (level.size() == 1) {
            TreeNode n = level.get(0);
            return isNodesSymmetric(n.left, n.right);
        }
        for (int i=0; i < level.size() / 2; i++) {
            TreeNode a = level.get(i);
            TreeNode b = level.get(level.size() - i - 1);
            if (a.val != b.val || !isNodesSymmetric(a.left, b.right) || !isNodesSymmetric(a.right, b.left)) {
                System.out.println("" + a.val + b.val);
                return false;
            }
        }
        return true;
    }
    
    private boolean isNodesSymmetric(TreeNode a, TreeNode b) {
        return a == null && b == null || a != null && b != null && a.val == b.val;
    }
}