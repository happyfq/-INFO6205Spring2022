/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        Map<Node, Node> map = new HashMap<>();
        Deque<Node> que = new LinkedList<>();
        que.add(node);
        map.put(node, new Node(node.val, new ArrayList()));
        while (!que.isEmpty()) {
            Node poll = que.remove();
            for (Node neighbor : poll.neighbors) {
                if (!map.containsKey(neighbor)) {
                    que.add(neighbor);
                    map.put(neighbor, new Node(neighbor.val, new ArrayList()));
                }
                map.get(poll).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}