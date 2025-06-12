package leecode.easy;

import Utils.TestUtil;
import dto.ListNode;

public class LC234 {
    // 时间复杂度O(n),
    // 空间复杂度O(1)
    public static void main(String[] args) {
        LC234 lc234 = new LC234();

        int [] array = {1,2,3,5,4,3,2,1};
        TestUtil util = new TestUtil();
        ListNode list= util.buildList(array);
        System.out.println(lc234.isPalindrome(list));
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //裁剪
        ListNode last = slow.next;
        slow.next = null;//断开
        ListNode reverseLast = reverse(last);

        return compare(reverseLast, head);
    }

    public ListNode reverse(ListNode head){
        ListNode tmp = head;
        ListNode pre = tmp;
        tmp = tmp.next;
        pre.next = null;

        while(tmp != null){
            ListNode next = tmp.next;
            tmp.next = pre;
            pre = tmp;
            tmp = next;
        }
        return pre;
    }

    public boolean compare (ListNode l1, ListNode l2){
        while(l1 != null){
            if(l1.val == l2.val){
                l1 = l1.next;
                l2 = l2.next;
            }else {
                return false;
            }
        }
        return true;
    }
}
