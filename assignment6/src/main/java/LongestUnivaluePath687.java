/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        int l = 0, r = 0;
        if (node.left != null && node.left.val == node.val) {
            l += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            r += right + 1;
        }
        ans = Math.max(ans, l + r);
        return Math.max(l, r);
    }
}