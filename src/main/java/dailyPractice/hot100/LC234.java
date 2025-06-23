package dailyPractice.hot100;

import dto.ListNode;

/**
 * 回文链表
 */
public class LC234 {

    //递归算法，先递归到尾部，然后在逐一对比，利用栈的原理
    private ListNode frontPointer;

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }


    public boolean isPalindrome2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        //先反转，在逐一对比即可
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        while(pre != null && head != null) {
            if (pre.val != head.val) {
                return false;
            } else {
                pre = pre.next;
                head = head.next;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        ListNode tes = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1, null))));
        LC234 lc234 = new LC234();
        System.out.println(lc234.isPalindrome(tes));
    }
}
