package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class TwoSumIV {

    public class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 1. transfer tree to sorted list
     * 2. use two point to search from head and tail
     *
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget1(TreeNode root, int k) {
        // transfer the tree to a sorted list
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    /**
     * use DFS and Set
     *
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget2(TreeNode root, int k) {
        // DFS
        return dfs(root, k, new HashSet<>());

    }

    private boolean dfs(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return dfs(root.left, k, set) || dfs(root.right, k, set);
    }

    /**
     * use BFS and Set
     *
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget3(TreeNode root, int k) {
        // BFS
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                continue;
            }
            if (set.contains(k - node.val)) {
                return true;
            }
            set.add(node.val);
            queue.add(node.left);
            queue.add(node.right);
        }
        return false;
    }

}
