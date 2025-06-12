package JZoffer;

import dto.TreeNode;

public class JZ18 {
    public void Mirror(TreeNode root) {

        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){//子节点不用反转
            return;
        }else {
            //反转
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            if(root.left != null){
                Mirror(root.left);
            }
            if(root.right != null){
                Mirror(root.right);
            }
        }
    }
}
