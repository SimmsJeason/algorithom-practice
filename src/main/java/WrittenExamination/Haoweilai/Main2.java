package WrittenExamination.Haoweilai;

import Utils.TestUtil;
import dto.ListNode;

public class Main2 {
    public static void main(String[] args) {
        TestUtil util = new TestUtil();
        int [] array = {1};
        ListNode head = util.buildList(array);
        Main2 main2 = new Main2();
        ListNode tt = main2.reverseList(head);
        while(tt != null){
            System.out.print(tt.val + " ");
            tt= tt.next;
        }
    }
        public ListNode reverseList (ListNode head) {
            // write code here

            if(head == null){
                return null;
            }

            ListNode newHead = new ListNode(-1);

            ListNode tmp = head;

            while(tmp != null){
                ListNode next = tmp.next;
                //头插法
                tmp.next = newHead.next;
                newHead.next = tmp;
                tmp = next;
            }
            return newHead.next;
        }
}
