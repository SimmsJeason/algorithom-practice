package CM;

import dto.ListNode;
import dto.TreeNode;


public class CM21 {
    ListNode head  = new ListNode(0);
    ListNode tmp  = head;

    public ListNode getTreeLevel(TreeNode root, int dep) {
        // write code here

        get(root, 1, dep);
        return head.next;
    }

    public void get(TreeNode root, int curDep, int dep){
        if(curDep == dep){
            tmp.next = new ListNode(root.val);
            tmp = tmp.next;
            return;
        }

        if(root.left != null){
            get(root.left, curDep +1, dep);
        }

        if(root.right != null){
            get(root.right, curDep +1, dep);

        }
    }
}
