package leecode.easy;

import dto.ListNode;

public class LC160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode tmpA = headA;
        ListNode tmpB = headB;

        /**
         * 假设 两个list共同的部分长度为 c
         * 那么 listA的长度可以表示为： lenA = a + c
         * listB的长度可以表示为： lenB = b + c
         * a == b 不一定成立， a 可以 不等于 b
         * 但是 a + b + c = a + b + c
         * 利用
         *
         */
        while (tmpA != tmpB){
          tmpA = (tmpA != null) ? tmpA.next : headB;
          tmpB = (tmpB != null) ? tmpB.next : headA;
        }

        return tmpA;
    }
}
