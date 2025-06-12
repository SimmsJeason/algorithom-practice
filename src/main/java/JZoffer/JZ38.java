package JZoffer;

import dto.TreeNode;

public class JZ38 {
    public int TreeDepth(TreeNode root) {

        if(root == null){
            return 0;
        }

        return Math.max(1+ TreeDepth(root.left), 1+TreeDepth(root.right));
    }

}
