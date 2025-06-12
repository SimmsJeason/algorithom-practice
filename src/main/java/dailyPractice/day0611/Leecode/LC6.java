package dailyPractice.day0611.Leecode;

import dto.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class LC6 {
    public ArrayList<Integer> postorderTraversal (TreeNode root) {
        // write code here
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<TreeNode> visited = new ArrayList<>();
        if(root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode tmp = stack.peek();
            if(tmp.left != null && !visited.contains(tmp.left)){
                stack.push(tmp.left);
            }else if(tmp.right != null&& !visited.contains(tmp.right)){
                stack.push(tmp.right);
            }else {
                res.add(tmp.val);
                visited.add(stack.pop());
            }
        }

        return res;
    }
}
