package leecode.easy;

import dto.ListNode;

public class LC206 {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode tmp = head;
        while(tmp != null){
            ListNode next = tmp.next;
            tmp.next = pre;
            pre = tmp;
            tmp = next;
        }
        return pre;
    }

}
