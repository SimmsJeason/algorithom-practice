package Utils;

import dto.TreeNode;

/**
 * [1,1,1,1,0,0,1,1,0,0,0,1,1] k = 2, 求改变 k次 将0 改为 1 ,求连续 1 的长度。
 *
 * 该题 结果为 8
 */
public class Test1 {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        return build(pre, 0, pre.length -1, in, 0, in.length -1);
    }

    public TreeNode build (int [] pre, int p, int q, int [] in , int i, int j){
        if(p > q) return  null;
        if(p == q) return  new TreeNode(pre[p]);

        //根节点
        TreeNode node = new TreeNode(pre[p]);
        int k = i;
        while(pre[p] != in[k]) k++;

        node.left = build(pre, p, p + k-i, in, i, k-1);
        node.right = build(pre, p + k-i+1, q, in, k+1, j);
        return node;
    }


}
