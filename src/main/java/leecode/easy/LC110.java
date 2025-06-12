package leecode.easy;

import Utils.TestUtil;
import dto.TreeNode;

public class LC110 {
    public static void main(String[] args) {
        int [] array = {1,2,2,3,3,12345,123456,4,4};
        TestUtil util = new TestUtil();
        TreeNode root = util.buildTree(array);

        LC110 lc110 = new LC110();

        System.out.println(lc110.isBalanced(root));
    }

    private boolean result = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (Math.abs(l - r) > 1) result = false;// 求深度的过程可以顺便完成判断操作
        return 1 + Math.max(l, r);
    }

    public boolean isBalanced2(TreeNode root) {
        if(root == null){
            return true;
        }

       int left = depth(root.left);
        int right = depth(root.right);
        if(Math.abs(left -right)>1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        return Math.max(left,right);

    }

}
