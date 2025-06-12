package JZoffer;

import dto.ListNode;

public class JZ15 {
    public ListNode ReverseList(ListNode head) {

        ListNode cur = head;
        ListNode next = null;
        ListNode reverseHead = new ListNode(0);
        reverseHead.next = null;
        while (cur != null){
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }

        reverseHead = reverseHead.next;
      return reverseHead;
    }
}
