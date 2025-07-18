package DataStructure.Tree.BST;


import dto.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LC108 {

    public TreeNode sortedArrayToBST(int[] nums) {

    return buildTree(nums, 0, nums.length-1);
    }


    public TreeNode buildTree(int [] nums , int left, int right){
        if(left > right) return null;

        int mid = (left + right + 1) /2;//中值取较大数
        TreeNode root = new TreeNode(nums[mid]);
        root. left = buildTree(nums, left, mid - 1);
        root.right = buildTree(nums, mid + 1 , right);

        return root;
    }
}
