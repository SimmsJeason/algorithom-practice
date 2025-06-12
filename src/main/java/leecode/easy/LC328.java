package leecode.easy;

import Utils.TestUtil;
import dto.ListNode;

public class LC328 {
    public static void main(String[] args) {
        LC328 lc328 = new LC328();
        int [] array = {1,2,3,4,5,6};
        TestUtil util = new TestUtil();
        ListNode list= util.buildList(array);
        ListNode res = lc328.oddEvenList(list);

        while(res != null){
            System.out.print( res.val + " ");
            res = res.next;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public ListNode oddEvenList1(ListNode head) {
        if(head == null) return null;

        ListNode odd = new ListNode(-1);
        ListNode res = odd;

        ListNode even = new ListNode(-1);
        ListNode evenTmp = even;

        ListNode tmp = head;
        boolean isOdd = true;
        while(tmp != null){
            if(isOdd){
                odd.next = tmp;
                odd = odd.next;
                tmp = tmp.next;
                odd.next = null;
                isOdd = false;
            }else {
                even.next = tmp;
                even = even.next;
                tmp = tmp.next;
                even.next = null;
                isOdd = true;
            }
        }
        odd.next = evenTmp.next;

        return res.next;
    }
}
