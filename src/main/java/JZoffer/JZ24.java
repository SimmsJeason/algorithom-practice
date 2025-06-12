package JZoffer;

import dto.TreeNode;

import java.util.ArrayList;

public class JZ24 {
    private ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> data = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root==null){
            return path;
        }
        data.add(root.val);
        target -= root.val;
        if(target == 0 && root.right == null && root.left == null){
            path.add(new ArrayList<Integer>(data));
        }

        FindPath(root.left,target);
        FindPath(root.right,target);

        data.remove(data.size()-1);
        return path;
    }

}
