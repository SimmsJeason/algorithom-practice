package Hot100;

import dto.TreeNode;

/**
 * 二叉树的最大深度
 * 已解答
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个二叉树 root ，返回其最大深度。
 *
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 */
public class LC104 {
    public int maxDepth(TreeNode root) {
        int depth = 0;
        dfs(root, depth);
        return depth;
    }

    public void dfs(TreeNode root, Integer depth) {
        if (root == null) {
            return;
        }
        depth++;
        dfs(root.left, depth);
        dfs(root.right, depth);
        depth--; //恢复
    }


}
