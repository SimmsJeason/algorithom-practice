package DataStructure.ListNode;

import dto.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 */
public class LC19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;//快慢结点
        while (n-- > 0) {
            fast = fast.next;
        }
        if (fast == null) return head.next;
        ListNode slow = head;

        while (fast.next != null) {//注意是fast.next!= null
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
