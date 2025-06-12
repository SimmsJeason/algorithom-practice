package JZoffer;

import dto.ListNode;

import java.util.List;

public class JZ46 {
    public int LastRemaining_Solution(int n, int m) {
        if(n == 0){
            return -1;
        }

        ListNode head = new ListNode(0);
        ListNode tmp = head;
        for(int i = 1; i<n; i++){
            ListNode next = new ListNode(i);
            tmp.next = next;
            tmp = tmp.next;
        }
        tmp.next = head;
        ListNode pre = tmp;//尾部元素

        tmp = head;
        int num = 1;

        while(pre != tmp){

            if(num == m){
                pre.next = tmp.next;
                tmp = tmp.next;
                num = 1;
            }else {
                pre = pre.next;
                tmp = tmp.next;
                num++;
            }
        }

        return pre.val;
    }
}
