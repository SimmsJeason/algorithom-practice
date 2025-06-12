package JZoffer;

import dto.TreeNode;

public class JZ26 {
    TreeNode [] prefix = new TreeNode[100];
    int i = 0;

    public TreeNode Convert(TreeNode pRootOfTree) {

        prefix(pRootOfTree);

        int j = 0;
       while (prefix[j] !=null){
           if(j-1>=0){
               prefix[j].left = prefix[j-1];
           }else {
               prefix[j].left = null;
           }

           if(prefix[j+1] != null){
               prefix[j].right = prefix[j+1];
           }else {
               prefix[j].right = null;
           }
           j++;
       }

       return prefix[0];
    }

    //前序遍历
    public void prefix(TreeNode root){

        if(root == null){
            return;
        }

        if(root.left != null){
             prefix(root.left);
        }


        prefix[i] = root;
        i++;

        if(root.right != null){
            prefix(root.right);
        }
    }
}
