package Review;

import Utils.TestUtil;
import dto.ListNode;

public class List_24 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        TestUtil util = new TestUtil();
        ListNode list = util.buildList(nums);
        List_24 list_24 = new List_24();

        list_24.swapPairs(list);
    }

    //从头部判定
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode top = new ListNode(-1);
        top.next = head;
        ListNode pre= top;

        while(pre.next != null && pre.next.next != null){
            ListNode l1 = pre.next;
            ListNode l2 = pre.next.next;
            l1.next = l2.next;
            l2.next = l1;
            pre.next = l2;

            pre = l1;
        }

        return top.next;
    }

    //从尾部判定
    public ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode top = new ListNode(-1);
        top.next = head;
        ListNode pre= top;
        ListNode last = pre.next.next;
        ListNode[] window = new ListNode[2];

        while(last != null){
            window[0] = pre.next;
            window[1] = last;
            window[0].next = last.next;
            window[1].next = window[0];
            last = window[0];//last 要重定向

            pre.next = window[1];

            pre = pre.next.next;
            if(last.next == null) break;
            last = last.next.next;
        }

        return top.next;
    }
}
