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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // BFS求坐标
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueI = new LinkedList<>();
        Queue<Integer> queueJ = new LinkedList<>();
        queueNode.offer(root);
        queueI.offer(0);
        queueJ.offer(0);

        Map<Integer, Map<Integer, List<Integer>>> hashmap = new HashMap<>();
        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int i = queueI.poll();
            int j = queueJ.poll();
            if (!hashmap.containsKey(j)) {
                hashmap.put(j, new HashMap<>());
            }
            if (!hashmap.get(j).containsKey(i)) {
                hashmap.get(j).put(i, new ArrayList<>());
            }
            hashmap.get(j).get(i).add(node.val);
            if (node.left != null) {
                queueNode.offer(node.left);
                queueI.offer(i + 1);
                queueJ.offer(j - 1);
            }
            if (node.right != null) {
                queueNode.offer(node.right);
                queueI.offer(i + 1);
                queueJ.offer(j + 1);
            }
        }

        // 排序
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        List<Integer> js = new ArrayList(hashmap.keySet());
        Collections.sort(js);
        for (Integer j : js) {
            tmp = new ArrayList<>();
            Map<Integer, List<Integer>> map = hashmap.get(j);
            List<Integer> is = new ArrayList(map.keySet());
            Collections.sort(is);
            for (Integer i : is) {
                List<Integer> values = map.get(i);
                Collections.sort(values);
                tmp.addAll(values);
            }
            res.add(tmp);
        }
        return res;
    }
}
