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
    int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        dfs(root, map, 0, targetSum);
        return ans;
    }

    private void dfs(TreeNode node, Map<Integer, Integer> map, int currSum, int targetSum) {
        if (node == null) {
            return;
        }
        currSum += node.val;
        ans += map.getOrDefault(currSum - targetSum, 0);
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        dfs(node.left, map, currSum, targetSum);
        dfs(node.right, map, currSum, targetSum);
        map.put(currSum, map.getOrDefault(currSum, 0) - 1);
    }
}