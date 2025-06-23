package dailyPractice.hot100;

import dto.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表 II
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 不允许修改 链表。
 */
public class LC142 {
    /**
     * 快慢指针
     * 设链表中环外部分的长度为 a。slow 指针进入环后，又走了 b 的距离与 fast 相遇。此时，fast 指针已经走完了环的 n 圈，
     * 因此它走过的总距离为 a+n(b+c)+b=a+(n+1)b+nc
     * 快指针路程为 2(a+b)
     * a+(n+1)b+nc = 2a + 2b
     * a = c+(n−1)(b+c)
     * 当发现 slow 与 fast 相遇时，我们再额外使用一个指针 ptr。起始，它指向链表头部；随后，它和 slow 每次向后移动一个位置。最终，它们会在入环点相遇。
     */

    public ListNode detectCycle3(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

    //哈希表
    public ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<ListNode>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        int index = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int pos = -1;
        ListNode cur = head;
        while (cur != null) {
            if (hashMap.containsKey(cur.val)) {
                pos = hashMap.get(cur.val);
                break;
            }
            hashMap.put(cur.val, index);
            cur = cur.next;
            index++;
        }
        if (pos == -1) {
            return null;
        }
        for (int i = 0; i < pos; i++) {
            head = head.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        /*node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;*/
        LC142 lc142 = new LC142();
        ListNode res = lc142.detectCycle(node1);
        System.out.println(res);
    }
}
