package Utils;

import dto.ListNode;
import dto.TreeNode;

public class TestUtil {
    public void infix(TreeNode root){

        System.out.print(root.val + " ");


        if(root.left != null){
            infix(root.left);
        }

        if(root.right != null){
            infix(root.right);
        }

    }

    public ListNode buildList(int [] array){
        ListNode head = new ListNode(array[0]);
        ListNode tmp = head;
        for(int i = 1; i< array.length; i++){
            ListNode cur = new ListNode(array[i]);
            tmp.next = cur;
            tmp = tmp.next;
        }
        return head;
    }

    public TreeNode buildTree(int [] array){
        TreeNode[] treeNodes = new TreeNode[array.length];
        for(int i = 0 ; i< array.length; i++){
            TreeNode cur = new TreeNode(array[i]);
            treeNodes[i] = cur;
        }

        for(int i = 0 ; i < treeNodes.length; i++){
            int left = i*2 +1;
            int right = (i+1)*2;

            if(left < treeNodes.length && treeNodes[left].val != 12345){
                treeNodes[i].left = treeNodes[left];
            }

            if(right < treeNodes.length && treeNodes[right].val != 12345){
                treeNodes[i].right = treeNodes[right];
            }
        }
        return treeNodes[0];
    }
}
