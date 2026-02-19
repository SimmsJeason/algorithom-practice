package TypicalAlgorithm.Sort.MergeSort;


import dto.ListNode;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 自顶向下归并排序
 * 对链表自顶向下归并排序的过程如下。
 * 找到链表的中点，以中点为分界，将链表拆分成两个子链表。寻找链表的中点可以使用快慢指针的做法，快指针每次移动 2 步，慢指针每次移动 1 步，当快指针到达链表末尾时，慢指针指向的链表节点即为链表的中点。
 * 对两个子链表分别排序。
 * 将两个排序后的子链表合并，得到完整的排序后的链表。可以使用「21. 合并两个有序链表」的做法，将两个有序的子链表进行合并。
 * 上述过程可以通过递归实现。递归的终止条件是链表的节点个数小于或等于 1，即当链表为空或者链表只包含 1 个节点时，不需要对链表进行拆分和排序。
 */
public class LC148 {

    //自顶向下的归并排序
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) { //只有一个节点不用排
            return head;
        }
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) { // 归并的模板，头尾指针
        if (head == null) {
            return head;
        }

        if (head == tail) { // 头尾指到同一个下边，即只有一个节点的情况
            head = null; //从链表断开， 返回
            return head;
        }
        // 快慢指针找中间节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail) {
            fast = fast.next;
            slow = slow.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        return merge(list1, list2);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummyHead = new ListNode(0); //虚拟头用来返回
        // 需要穿针引线，所以需要构造临时节点来完成
        ListNode temp = dummyHead, temp1 = left, temp2 = right;

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

        if (temp1 == null) {
            temp.next = temp2;
        } else {
            temp.next = temp1;
        }
        return dummyHead.next;
    }
}
