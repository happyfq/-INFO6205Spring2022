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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();
        if (root == null) {
            return res;
        }
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode tmp = que.poll();
                max = Math.max(max, tmp.val);
                if (tmp.left != null) {
                    que.offer(tmp.left);
                }
                if (tmp.right != null) {
                    que.offer(tmp.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}