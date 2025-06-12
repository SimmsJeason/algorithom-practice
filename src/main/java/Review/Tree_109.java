package Review;

import Utils.TestUtil;
import dto.ListNode;
import dto.TreeNode;

public class Tree_109 {

    public static void main(String[] args) {
        TestUtil util = new TestUtil();
        Tree_109 test = new Tree_109();
        int [] nums = {1,2,3,4,5,6};
        ListNode head = util.buildList(nums);

        TreeNode root = test.sortedListToBST(head);
        System.out.println(root.val);
    }

    //链表取中间节点
    public TreeNode sortedListToBST(ListNode head) {
        TreeNode root;
        if(head.next == null) {
            root = new TreeNode(head.val);
            return root;
        }

        ListNode pre = head;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }


}
