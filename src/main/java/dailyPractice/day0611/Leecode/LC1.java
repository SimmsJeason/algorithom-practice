package dailyPractice.day0611.Leecode;

import dto.TreeNode;

public class LC1 {
    public int run (TreeNode root) {
        // write code here
        if(root == null){
            return 0;
        }

        return run2(root);
    }

    public int run2 (TreeNode root) {
        // write code here
        if(root == null){
            return Integer.MAX_VALUE;
        }

        if(root.left == null && root.right == null){
            return 1;
        }

        return Math.min(1+ run2(root.left), 1 + run2(root.right));
    }
}
