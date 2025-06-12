package dailyPractice.day0611.Leecode;

import dto.TreeNode;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

public class LC7 {
    //涉及到递归的转变，基本都是用栈来替换

    ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if(root == null)
            return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if(temp.right != null) //先添加右子结点
                stack.push(temp.right);
            if(temp.left != null) // 再添加左子节点
                stack.push(temp.left);
        }
        return list;
    }
}
