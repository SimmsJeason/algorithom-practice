package TypicalAlgorithm.ListNode;


import dto.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 排序链表
 */
public class LC148 {
    //归并排序
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }


    //复制 排序，有点作弊
    public ListNode sortList2(ListNode head) {
        if (head == null) {
            return head;
        }
        List<Integer> copy = new ArrayList<>();
        while (head != null){
            copy.add(head.val);
            head = head.next;
        }
        copy.sort((Comparator.comparingInt(o -> o)));
        ListNode newHead = new ListNode(copy.get(0));

        ListNode current = newHead;
        for (int i = 1; i < copy.size(); i++) {
            current.next = new ListNode(copy.get(i));
            current = current.next;
        }
      return newHead;
    }
}
