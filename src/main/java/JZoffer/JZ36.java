package JZoffer;

import dto.ListNode;

public class JZ36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode tmp1 = pHead1;

        while (tmp1 != null){
            ListNode tmp2 = pHead2;

            while (tmp2 != null){
                if(tmp1 == tmp2){
                    return tmp2;
                }else {
                    tmp2 = tmp2.next;
                }
            }

            tmp1 = tmp1.next;
        }

        return null;
    }
}
