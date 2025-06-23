package dailyPractice.hot100;

import dto.ListNode;

/**
 相交链表
 */
public class LC160 {

    /**
     * length(A) = a, length(B) = b, 设公共部分的节点数量为c
     * 所有的节点个数为 a + b - c
     *  skipA = a-c; skipB = b-c
     *  从A头节点开始走，走完a 再到b的公共节点为： a + (b-c)
     *  从B头节点开始走，走完b 再到a的公共节点为： b + (a-c)
     *  这俩相等 = 总共的节点数
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode aaa = headA;
        ListNode bbb = headB;

        while (aaa != bbb) {
            aaa = aaa != null ? aaa.next : headB;//到达 A的尾部，转接到B
            bbb = bbb != null ? bbb.next : headA;
        }
        return aaa;
    }
}



