package leecode.easy;

import dto.ListNode;


public class LC83 {
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode pre = head;
        if(head == null) return null;
        ListNode tmp = head.next;

        while (tmp != null){

            if(pre.val == tmp.val){
                tmp = tmp.next;
                pre.next = tmp;
            }else {
                tmp = tmp.next;
               pre = pre.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
