package leecode.easy;

import Utils.TestUtil;
import dto.TreeNode;

public class LC104 {
    public static void main(String[] args) {
        int [] array = {3,9,20,12345,12345,15,7};
        TestUtil util = new TestUtil();
        TreeNode root = util.buildTree(array);

        LC104 lc104 = new LC104();

        System.out.println(lc104.maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left)+ 1;
        int right = maxDepth(root.right) + 1;
        return Math.max(left, right);
    }
}
