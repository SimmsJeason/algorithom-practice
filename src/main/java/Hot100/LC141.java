package Hot100;

import dto.ListNode;

/**
 * 环形链表
 * 已解答
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 */
public class LC141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
       /* ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);*/
        node1.next = node2;
        node2.next = node1;
      /*  node3.next = node4;
        node4.next = node2;*/
        LC141 lc141 = new LC141();
        System.out.println(lc141.hasCycle(node1));
    }
}
