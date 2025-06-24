package dto;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
     public int val;
     public TreeNode left;
     public TreeNode right;
     public TreeNode(int x) { val = x; }
    public TreeNode buildTree(int[] nodes) {
        if (nodes == null || nodes.length == 0 || nodes[0] == Integer.MIN_VALUE) {
            return null;
        }

        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < nodes.length) {
            TreeNode current = queue.poll();

            if (nodes[i] != Integer.MIN_VALUE) {
                current.left = new TreeNode(nodes[i]);
                queue.add(current.left);
            }
            i++;

            if (i < nodes.length && nodes[i] != Integer.MIN_VALUE) {
                current.right = new TreeNode(nodes[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }
  }