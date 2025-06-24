package dailyPractice.hot100;

import dto.ListNode;

/**
 * 两数相加
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */

public class LC2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
          int n1 = l1 == null ? 0 : l1.val;
          int n2 = l2 == null ? 0 : l2.val;
          int sum = n1 + n2 + carry;
          carry = sum / 10;
          if(head == null) {
              head = tail = new ListNode(sum % 10);
          } else {
              tail.next = new ListNode(sum % 10);
              tail = tail.next;
          }
          if (l1 != null) {
              l1 = l1.next;
          }
          if (l2 != null) {
              l2 = l2.next;
          }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }









    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null; // 头尾指针
        int carry = 0; //进位标识
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode nodeA = new ListNode(5);
        ListNode nodeB = new ListNode(6);
        ListNode nodeC = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        LC2 lc2 = new LC2();
        ListNode res = lc2.addTwoNumbers(node1, nodeA);
        System.out.println(res);
    }
}
