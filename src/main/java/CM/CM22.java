package CM;

import dto.TreeNode;

import java.util.ArrayList;

public class CM22 {
    ArrayList<Integer> arrayList = new ArrayList<>();
    public boolean checkBST(TreeNode root) {
        // write code here

        prefix(root);
        for(int i = 0; i< arrayList.size() -1; i++){
            if(arrayList.get(i) > arrayList.get(i+1)){
                return false;
            }
        }
        return true;
    }

    public void prefix(TreeNode root){
        if(root == null){
            return;
        }

        if(root.left != null){
            prefix(root.left);
        }
        arrayList.add(root.val);

        if(root.right != null){
            prefix(root.right);
        }
    }
}
