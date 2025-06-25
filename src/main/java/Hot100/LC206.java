package Hot100;

import dto.ListNode;

/**
 * 反转链表
 */
public class LC206 {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
    /*    while (cur != null) {
            ListNode next = cur.next;
            ListNode last = pre;
            pre = cur;
            pre.next = last;
            cur = next;
        }*/
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode res = new ListNode(head.val);
        head = head.next;
        while (head != null) {
            ListNode copy = new ListNode(head.val);
            copy.next = res;
            head = head.next;
            res = copy;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode tes = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        LC206 lc206 = new LC206();
        tes = lc206.reverseList(tes);
        while (tes != null) {
            System.out.print(tes.val + ",");
            tes = tes.next;
        }
    }
}
