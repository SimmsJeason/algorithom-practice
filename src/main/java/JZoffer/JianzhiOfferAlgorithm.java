package JZoffer;

import dto.ListNode;
import dto.TreeNode;

import java.util.ArrayList;


public class JianzhiOfferAlgorithm {

    public boolean Find(int target, int [][] array) {
        int dimension = array.length;

        if(array == null || array.length == 0 || (array.length==1&&array[0].length==0)){
            return false;
        }

        if (target < array[0][0] || target > array[dimension - 1][dimension - 1]) {
            return false;
        } else {
            for (int i = 0; i < dimension; i++) {
                if (target == array[i][i]) {
                  return true;
                } else if (target > array[i][i]) {
                    for(int j = i + 1; j < dimension; j++){
                        if(target == array[i][j] || target == array[j][i]){
                       return true;
                        }
                    }
                } else {
                  return false;
                }
            }
        }
        return false;
    }

    public String replaceSpace(StringBuffer str){
        String ss = str.toString();

        return ss.replace(" ", "%20");
    }



    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer>  result = new ArrayList<Integer>();

        if(listNode != null ){
            if(listNode.next == null ){
                result.add(listNode.val);
            }else {
                while(listNode.next !=null){
                    result.add(listNode.val);
                    listNode = listNode.next;
                }
                result.add(listNode.val);
                //反转list
                int size = result.size();
                for(int i = 0; i< size/2; i++){
                    int tmp = result.get(i);
                    result.set(i, result.get(size-i-1));
                    result.set(size-1-i, tmp);
                }
            }
        }

        return result;
    }

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
       return build(pre, 0, pre.length -1, in, 0, in.length -1);
    }

    public TreeNode build (int [] pre, int p, int q, int [] in ,int i, int j){

        if(p > q) return null;
        if(p == q) return  new TreeNode(pre[p]);

        TreeNode node = new TreeNode(pre[p]);
        int k = i;//子树在中序序列数组的起始脚标

        while(pre[p] != in[k]) k++;//求得子树结束的角标，k-i 为子树的长度
        //left tree
        node.left = build(pre, p+1, p+k-i, in, i, k-1);
        // right tree
        node.right = build(pre, p+k-i+1, q, in, k+1, j);

        return node;
    }

}

