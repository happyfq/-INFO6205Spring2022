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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();
        if (root == null) {
            return res;
        }
        que.offerLast(root);
        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = que.poll();
                level.add(tmp.val);
                if (tmp.left != null) {
                    que.offerLast(tmp.left);
                }
                if (tmp.right != null) {
                    que.offerLast(tmp.right);
                }
            }
            res.add(0, level);
        }
        return res;
    }
}