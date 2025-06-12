package CM;

import dto.TreeNode;

public class CM20 {
    public int buildMinimalBST(int[] vals) {
        // write code here
        if(vals.length == 0){
            return 0;
        }

        return build(vals, 0 , vals.length);
    }

/*    public void buildTree(int [] vals, int i, int j, TreeNode root){
        int mid = (i + j)/2 ;
        if(i <= j && mid >= 0 && mid < vals.length){
            root.val = vals[mid];
            root.left = new TreeNode(0);
            buildTree(vals, i, mid-1, root.left);
            root.right = new TreeNode(0);
            buildTree(vals, mid +1, j, root.right);
        }else {
            return;
        }
    }*/

    public int build(int[] vals, int start, int end) {
        if (end <= start) {
            return 1;
        }
        int mid = (start + end) >> 1;
        int height1 = 1 + build(vals, start, mid - 1);
        int height2 = 1 + build(vals, mid + 1, end);
        return Math.max(height1, height2);

    }
}
