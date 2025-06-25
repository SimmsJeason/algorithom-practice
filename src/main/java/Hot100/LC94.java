package Hot100;

import dto.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历
 */
public class LC94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        mid(root, res);
        return res;
    }

    public void mid(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        mid(root.left, res);
        res.add(root.val);
        mid(root.right, res);
    }

}
