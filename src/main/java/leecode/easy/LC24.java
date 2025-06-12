package leecode.easy;

import Utils.TestUtil;
import dto.ListNode;

public class LC24 {
    public static void main(String[] args) {
        LC24 lc24 = new LC24();
        int [] array = {1,2,3,4,5,6};
        TestUtil util = new TestUtil();
        ListNode list= util.buildList(array);
        ListNode res = lc24.swapPairs(list);
        while(res != null){
            System.out.print( res.val + " ");
            res = res.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node;

        while (pre.next != null && pre.next.next != null) {
            ListNode l1 = pre.next, l2 = pre.next.next;
            ListNode next = l2.next;
            l1.next = next;
            l2.next = l1;
            pre.next = l2;

            pre = l1;
        }
        return node.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode top = new ListNode(-1);
        top.next = head;
        ListNode pre = top;
        ListNode l1 = head;
        ListNode l2 = head.next;

        while(l2 != null){
            l1.next = l2.next;
            l2.next = l1;
            pre.next = l2;

            //交换l1,l2。要保证l1指向交换的第一个节点，l2指向交换的第二个节点
            ListNode tmp = l1;
            l1 = l2;
            l2 = tmp;

            pre = l2;
            l1 = l1.next.next;
            if(l2.next != null){
                l2 = l2.next.next;
            }else {
                break;
            }
        }
        return top.next;
    }
}
