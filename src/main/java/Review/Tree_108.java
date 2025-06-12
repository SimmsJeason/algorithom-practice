package Review;

import dto.TreeNode;

public class Tree_108 {

    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums.length == 0) return null;
        int l = 0;
        int h = nums.length -1;
        int mid = l + (h-l) /2;

        TreeNode root = new TreeNode(nums[mid]);

        return root;
    }

    public TreeNode buildTree(int[] nums, int l, int h){

        if(l > h){
            return null;
        }

        int mid = l + (h-l) /2;
        TreeNode root = new TreeNode(nums[mid]);

        //左子树
        root.left = buildTree(nums, l, mid-1);
        root.right = buildTree(nums, mid + 1, h);

        return root;
    }
}
