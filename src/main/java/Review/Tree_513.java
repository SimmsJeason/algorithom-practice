package Review;

import dto.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Tree_513 {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode tmp = root;
        queue.add(root);

        int res = 0;
        while(queue.isEmpty()){

            TreeNode cur = queue.poll();
            res = cur.val;

            if(cur.right != null) {
                queue.add(cur.right);
            }

            if(cur.left != null) {
                queue.add(cur.left);
            }

        }

        return res;
    }
}
