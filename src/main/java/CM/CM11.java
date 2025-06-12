package CM;

import dto.ListNode;

public class CM11 {
    //超时
    public ListNode partition(ListNode pHead, int x) {

        if(pHead == null || pHead.next == null){
            return pHead;
        }

        ListNode littleHead = new ListNode(-1);
        littleHead.next = null;
        ListNode bigHead = new ListNode(-1);
        bigHead.next = null;
        ListNode tmp = pHead;
        ListNode tmpLittle = littleHead;
        ListNode tmpBig = bigHead;

        while(tmp != null){
            if(tmp.val < x){
                tmpLittle.next = new ListNode(tmp.val);
                tmpLittle = tmpLittle.next;
            }else {
                tmpBig.next = new ListNode(tmp.val);
                tmpBig = tmpBig.next;
            }
            tmp = tmp.next;
        }
        tmpLittle.next = bigHead.next;

        return littleHead.next;
    }
}
