package leecode.mid;

import Utils.TestUtil;
import dto.ListNode;

public class LC82 {
    public static void main(String[] args) {
        LC82 lc82 = new LC82();

        int [] array = {1,1,3,4,5,6,6};
        TestUtil util = new TestUtil();
        ListNode list= util.buildList(array);
        ListNode res = lc82.deleteDuplicates(list);
        while(res != null){
            System.out.print( res.val + " ");
            res = res.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;  // 若head为空则直接返回null
        ListNode dummy = new ListNode(-1);  // 建立一个虚拟头结点
        ListNode tail = dummy;  // 定义一个尾巴，用于尾插法。
        for (ListNode l = head, r = head; l != null; l = r) {
            while (r != null && r.val == l.val) r = r.next;  // 只要r不为空并且与l的值相等则一直向后移动
            if (l.next == r) {  // 若长度为1，则通过尾插法加入。
                tail.next = l;  // 基本的尾插法
                tail = l;
                tail.next = null;  // 这里记得将尾部的后面置为null，不然可能后面会带着一些其他的节点。
            }
        }
        return dummy.next;
    }



    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode top = new ListNode(-1);

        top.next = head;

        ListNode pre = top;
        ListNode start = head;
        ListNode end = head.next;
        while(end != null){
            if(start.val == end.val){
                while(end!= null && start.val == end.val){
                    end = end.next;
                }
                start = end;
                pre.next = start;
                if(end!= null){
                    end = end.next;
                }
            }else {
                pre =pre.next;
                start = start.next;
                end = end.next;
            }
        }
        return top.next;
    }
}
