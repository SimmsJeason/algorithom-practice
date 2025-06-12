package JZoffer;

import dto.ListNode;

public class JZ14 {
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode p = head;
        ListNode r = head;

        int i = 0;
        while (r != null){//不是 r.next != null
            if(i >= k ){
                p = p.next;
            }else {
                i++;
            }
            r = r.next;
        }

        return i<k ? null:p;

  /*      ListNode p = head;
        ListNode q = head;
        int i = 0;
        for(;p != null;i++)
        {
            if(i >= k)
            {
                q = q.next;
            }
            p = p.next;
        }
        return i < k ? null:q;*/
    }
}
