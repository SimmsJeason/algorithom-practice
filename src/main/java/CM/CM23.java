package CM;

import dto.TreeNode;

import java.util.ArrayList;

public class CM23 {
    ArrayList<Integer> infixOrder = new ArrayList<>();
    public int findSucc(TreeNode root, int p) {
        // write code here
        infix(root);
        for(int i = 0; i < infixOrder.size() -1; i++){
            if(infixOrder.get(i) == p){
                return infixOrder.get(i+1);
            }
        }
        return -1;
    }


    public void infix(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left != null){
            infix(root.left);
        }

        infixOrder.add(root.val);

        if(root.right != null){
            infix(root.right);
        }
    }

    public int infix2(TreeNode root, int p, boolean sign) {
        if(root == null){
            return -1;
        }


        int left = infix2(root.left, p, sign);
        if(left != -1){
            return left;
        }

        if(sign == true){
            return root.val;
        }

        if(root.val == p){
            sign = true;
        }

        return infix2(root, p, sign);
    }

}
