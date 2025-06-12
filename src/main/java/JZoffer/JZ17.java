package JZoffer;

import dto.TreeNode;

public class JZ17 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        boolean result = false;
        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if (root2 != null && root1 != null) {
            //如果找到了对应Tree2的根节点的点
            if(root1.val == root2.val){
                //以这个根节点为为起点判断是否包含Tree2
                result = similar(root1,root2);
            }
            //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.left,root2);
            }

            //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.right,root2);
            }
        }
        //返回结果
        return result;

    }

    public boolean similar(TreeNode root1, TreeNode root2){
        if(root2 == null){//说明 子树已经比较完毕
            return true;
        }else if(root1 == null){//父树已经比完，但是子树还有，说明父树没有对应的子结构
            return false;
        }else if(root1.val == root2.val){
            boolean left = similar(root1.left, root2.left);
            if(!left){
                return false;
            }
            boolean right = similar(root1.right, root2.right);

            return left && right;
        }else {
            return false;
        }
    }
}
