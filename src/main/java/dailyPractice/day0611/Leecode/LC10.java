package dailyPractice.day0611.Leecode;

import dto.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class LC10 {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }

        List<String> l2 = new ArrayList<>();
        List<String> l3 = Collections.synchronizedList(l2);
        l3.add("a");

        CopyOnWriteArrayList<String> copy = new CopyOnWriteArrayList<>();
        copy.add("a");
        return false;
    }
}

