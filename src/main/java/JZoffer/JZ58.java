package JZoffer;

import dto.TreeNode;

public class JZ58 {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null){
            return true;
        }
        return isSymmetrical2(pRoot.left, pRoot.right);
    }

    boolean isSymmetrical2(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }

        if(left == null || right ==null){
            return false;
        }

        return left.val == right.val && isSymmetrical2(left.left, right.right) && isSymmetrical2(left.right, right.left);
    }
}
