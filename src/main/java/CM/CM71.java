package CM;

import dto.ListNode;
import dto.TreeNode;

public class CM71 {
        ListNode head = new ListNode(0);
        ListNode tmpList = head;

        public ListNode treeToList(TreeNode root) {
            // write code here
            infix(root);
            return  head.next;
        }

        public void infix(TreeNode root){
            if(root == null){
                tmpList.next = null;
                return ;
            }

            if(root.left != null){
                infix(root.left);
            }

            tmpList.next = new ListNode(root.val);
            tmpList = tmpList.next;

            if(root.right != null){
                infix(root.right);
            }
        }

}
