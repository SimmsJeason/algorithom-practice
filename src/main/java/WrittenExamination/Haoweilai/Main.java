package WrittenExamination.Haoweilai;

import Utils.TestUtil;
import dto.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Main test = new Main();
        int [] array = {1};
        TestUtil util = new TestUtil();
        TreeNode root = util.buildTree(array);
        System.out.println(test.notReCuPreOrder(root));
    }

    public String notReCuPreOrder (TreeNode root) {
        // write code here

        if(root == null){
            return "";
        }
        StringBuffer sb = new StringBuffer();
        List<Integer> preOrder = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while(!stack.empty()){
            TreeNode cur = stack.pop();

            preOrder.add(cur.val);
            if(cur.right != null){
                stack.add(cur.right);
            }

            if(cur.left != null){
                stack.add(cur.left);
            }
        }

        for(int i = 0; i< preOrder.size(); i++){
            sb.append(preOrder.get(i).toString());
            if(i != preOrder.size() -1){
                sb.append(",");
            }
        }

        return sb.toString();
    }
}
