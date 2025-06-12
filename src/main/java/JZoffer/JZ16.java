package JZoffer;

import dto.ListNode;

public class JZ16 {
    public ListNode Merge(ListNode list1, ListNode list2) {

        ListNode tmpHead = new ListNode(0);
        tmpHead.next = null;
        ListNode tmp = tmpHead;

        ListNode l1 = list1;
        ListNode l2 = list2;

        while (l1 != null && l2 !=null){
            if(l1.val > l2.val){
                ListNode node = new ListNode(l2.val);
                node.next = tmp.next;
                tmp.next = node;
                tmp = tmp.next;
                l2 = l2.next;
            }else {
                ListNode node = new ListNode(l1.val);
                node.next = tmp.next;
                tmp.next = node;
                tmp = tmp.next;
                l1 = l1.next;
            }
        }

        while (l1 != null){
            ListNode node = new ListNode(l1.val);
            node.next = tmp.next;
            tmp.next = node;
            tmp = tmp.next;
            l1 = l1.next;
        }

        while (l2 != null){
            ListNode node = new ListNode(l2.val);
            node.next = tmp.next;
            tmp.next = node;
            tmp = tmp.next;
            l2 = l2.next;
        }

        return  tmpHead.next;
    }
}
