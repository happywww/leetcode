public class PruneTree {

    public class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left); // if (pruneTree(root.left)==null) root.left=null;
        root.right = pruneTree(root.right); // if (pruneTree(root.right)==null) root.right=null;
        if (root.val == 0 && pruneTree(root.left) == null && pruneTree(root.right) == null) {
            return null;
        }
        return root;
    }

}
