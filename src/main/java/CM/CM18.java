package CM;

import dto.TreeNode;

public class CM18 {
    public boolean isBalance(TreeNode root) {
        // write code here

        if(root == null){
            return true;
        }

        if(Math.abs(depth(root.left) - depth(root.right)) > 1){
            return false;
        }else {
            return isBalance(root.left) && isBalance(root.right);
        }
    }

    //求树的深度
    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }else {
            return Math.max(depth(root.left), depth(root.right)) + 1;
        }
    }
}
