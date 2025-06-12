package leecode.mid;

import Utils.TestUtil;
import dto.ListNode;

import java.util.Stack;

public class LC445 {
    public static void main(String[] args) {
        LC445 lc445 = new LC445();
        int [] array = {1,2,3,4,5,6};
        TestUtil util = new TestUtil();
        ListNode list1= util.buildList(array);
        ListNode list2= util.buildList(array);
        ListNode res = lc445.addTwoNumbers(list1, list2);
        while(res != null){
            System.out.print( res.val + " ");
            res = res.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int carry = 0;

        while(l1!=null){
            stack1.add(l1.val);
            l1 = l1.next;
        }

        while(l2 != null){
            stack2.add(l2.val);
            l2 = l2.next;
        }

        ListNode head = new ListNode(-1);
        ListNode work = head;
        while(!stack1.empty() && !stack2.empty()){
            int num1 = stack1.pop();
            int num2 = stack2.pop();
            int sum = num1 + num2 + carry;

            carry = sum / 10;
            ListNode tmp = new ListNode(sum % 10);
            tmp.next = work.next;
            work.next = tmp;

        }

        while(!stack1.empty()){
            int sum = stack1.pop() + carry;
            carry = sum / 10;
            ListNode tmp = new ListNode(sum % 10);
            tmp.next = work.next;
            work.next = tmp;
        }

        while(!stack2.empty()){
            int sum = stack2.pop() + carry;
            carry = sum / 10;
            ListNode tmp = new ListNode(sum % 10);
            tmp.next = work.next;
            work.next = tmp;
        }

        //最后还存在进位，就要再创建一个节点放数
        if(carry == 1){
            ListNode tmp = new ListNode(carry);
            tmp.next = work.next;
            work.next = tmp;
        }

        return head.next;
    }
}
