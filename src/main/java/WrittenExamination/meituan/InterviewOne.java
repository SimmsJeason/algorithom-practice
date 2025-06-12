package WrittenExamination.meituan;

import Utils.TestUtil;
import dto.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InterviewOne {

    public static void main(String[] args) {
        TestUtil util = new TestUtil();
        int [] array = {1,2,3,4,5,12345,12345,6};
        TreeNode root = util.buildTree(array);
        InterviewOne test = new InterviewOne();
        System.out.println(test.solve(root));
    }

    public int solve(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();

        preOrder(root, res, new ArrayList<>());
        int sum = 0;
        for(List<Integer> r : res){
            sum += merge(r);
        }
        return sum;
    }

    public void preOrder(TreeNode root, List<List<Integer>> res, List<Integer> cur){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            cur.add(root.val);
            res.add(new ArrayList<>(cur));
            cur.remove(cur.size()-1);//返回上一层需要回退路径
            return;
        }

        cur.add(root.val);
        preOrder(root.left, res, cur);

        preOrder(root.right, res, cur);

        //返回上一层需要回退路径
        //if(cur.size() >0){
            cur.remove(cur.size() -1);
        //}

    }

    public int merge(List<Integer> numList){
        int num = 0;
        int pre = 1;
        for(int i = numList.size() -1; i >=0; i--){
            num += numList.get(i)* pre;
            pre *= 10;
        }

        return num;
    }
}
