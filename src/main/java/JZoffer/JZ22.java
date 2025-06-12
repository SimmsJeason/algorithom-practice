package JZoffer;

import dto.TreeNode;

import java.util.ArrayList;

public class JZ22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int in = 0;
        int out = 0;
        TreeNode[] queue = new TreeNode[100]; //数组模拟队列

        queue[in ++ ] = root;

        while(in > out){
            if(queue[out] != null){
                result.add(queue[out].val);
                queue[in++] = queue[out].left;//左子树入队
                queue[in++] = queue[out].right;//右子树入队
            }
            out++;//当前结点出队
        }
        return result;
    }
}
