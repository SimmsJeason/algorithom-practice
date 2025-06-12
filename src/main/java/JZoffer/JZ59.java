package JZoffer;

import dto.TreeNode;

import java.util.ArrayList;

public class JZ59 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot == null){
            return result;
        }

        TreeNode[] queue = new TreeNode[100];
        int in =0;
        int out = 0;

        queue[in++] = pRoot;

        int i = 0;
        while (in != out){
            ArrayList<Integer> row = new ArrayList<>();

            if(i%2 == 0){
                for(int j = out; j < in; j++){
                    row.add(queue[j].val);
                }
                result.add(row);
                i++;

                int levelEnd = in;

                //将下一层放入队列
                for(; out< levelEnd; out++){
                    TreeNode cur = queue[out];
                    if(cur.left != null){
                        queue[in++] = cur.left;
                    }
                    if(cur.right != null){
                        queue[in++] = cur.right;
                    }
                }

            }else {
                for(int j = in - 1; j >=out; j--){
                    row.add(queue[j].val);
                }
                result.add(row);
                i++;

                int levelEnd = in;

                //将下一层放入队列
                for(; out< levelEnd; out++){
                    TreeNode cur = queue[out];
                    if(cur.left != null){
                        queue[in++] = cur.left;
                    }
                    if(cur.right != null){
                        queue[in++] = cur.right;
                    }
                }
            }
        }

        return result;
    }
}
