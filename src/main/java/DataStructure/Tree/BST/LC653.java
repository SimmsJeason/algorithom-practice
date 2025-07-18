package DataStructure.Tree.BST;

import dto.TreeNode;

import java.util.ArrayList;

/**
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 案例 1:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * 输出: True
 *  
 *
 * 案例 2:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC653 {
    ArrayList<Integer> nums = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {

        if(root == null) return false;
        infixOrder(root);
        int i = 0, j = nums.size() -1;

        while(i < j){
            if(nums.get(i) + nums.get(j) == k){
                return true;
            }else if(nums.get(i) + nums.get(j) > k){
                j--;
            }else {
                i++;
            }
        }

        return false;
    }

    public void infixOrder(TreeNode root){
        if(root.left != null) infixOrder(root.left);

        nums.add(root.val);

        if(root.right != null) infixOrder(root.right);
    }

}
