package JZoffer;

import dto.TreeNode;

public class JZ62 {
    TreeNode [] sort = new TreeNode[100];
    int i = 0;

    public TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null){
            return null;
        }

        infix(pRoot);

        if(k>=sort.length || k <= 0){
            return null;
        }

        return sort[k-1];
    }

    public void infix(TreeNode root){
        if(root.left != null){
            infix(root.left);
        }

        sort[i++] = root;

        if(root.right != null){
            infix(root.right);
        }

    }

}
