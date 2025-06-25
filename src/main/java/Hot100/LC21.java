package Hot100;

import dto.ListNode;

/**
 *  合并两个有序链表
 * 已解答
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 */
public class LC21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode pointer1 = list1;
        ListNode pointer2 = list2;
        ListNode res = new ListNode(-1);
        ListNode head = res;
        while (pointer1 != null || pointer2 != null) {
            if (pointer1 == null && pointer2 != null) {
                res.next = pointer2;
                return head.next;
            } else if (pointer1 != null && pointer2 == null) {
                res.next = pointer1;
                return head.next;
            }

            if (pointer1.val >= pointer2.val) {
                res.next = pointer2;
                res = res.next;
                pointer2 = pointer2.next;
            } else {
                res.next = pointer1;
                res = res.next;
                pointer1 = pointer1.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode nodeA = new ListNode(1);
        ListNode nodeB = new ListNode(3);
        ListNode nodeC = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        LC21 lc21 = new LC21();
        ListNode res = lc21.mergeTwoLists(node1, nodeA);
        System.out.println(res);
    }
}
