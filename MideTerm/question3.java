import java.util.Map;

class Solution3 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    public TreeNode build(int[] preorder, int ps, int pe, int[] inorder, int is, int ie, Map<Integer, Integer> map) {
        if (ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int iroot = map.get(root.val);
        int leftLen = iroot - is;
        root.left = build(preorder, ps + 1, ps + leftLen, inorder, is, iroot - 1, map);
        root.right = build(preorder, ps + leftLen + 1, pe, inorder, iroot + 1, ie, map);
        return root;
    }
}