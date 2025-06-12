package CM;

import dto.ListNode;


public class CM12 {
    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        ListNode head = new ListNode(0);
        head.next = null;

        ListNode tmp = head;

        if(a == null || b == null){
            return a;
        }

        boolean flag = false;
        while (a != null){
            if(b != null){
                int val = 0;

                if(flag){
                    val += 1;
                    flag = false;
                }

                val += a.val + b.val;

                if(val >=10){
                    int low = val%10;
                    flag = true;
                    ListNode t = new ListNode(low);
                    tmp.next = t;
                    tmp = tmp.next;
                }else {
                    ListNode t = new ListNode(val);
                    tmp.next = t;
                    tmp = tmp.next;
                }

                b= b.next;
            }else {
                ListNode t = new ListNode(a.val);
                tmp.next = t;
                tmp = tmp.next;
            }

            a = a.next;
        }


        while (b != null){
            ListNode t= new ListNode(b.val );
            if(flag){
                t.val += 1;
                flag = false;
            }
            tmp.next = t;
            tmp = tmp.next;
            b = b.next;
        }

        if(flag){
            ListNode t= new ListNode(1);
            tmp.next = t;
            tmp = tmp.next;
        }

        return head.next;
    }


    /*可以用此法完成大数加减，乘法也可以（加减乘都是从低位到高位）
    除法需要从高位开始到低位*/
        public class Plus {
        public ListNode plusAB(ListNode a, ListNode b) {
            // write code here
            if(a == null || b == null){
                return null;
            }
            int add = 0;
            ListNode head = new ListNode(-1);
            ListNode resCur = head;
            ListNode curA = a;
            ListNode curB = b;
            while(curA != null || curB != null){
                if(curA != null && curB !=null){
                    resCur.next = new ListNode((curA.val+curB.val+add)%10);
                    resCur = resCur.next;
                    add = (curA.val+curB.val+add)/10;
                    curA = curA.next;
                    curB = curB.next;
                }else if(curA != null){
                    resCur.next = new ListNode((curA.val+add)%10);
                    resCur = resCur.next;
                    add = (curA.val+add)/10;
                    curA = curA.next;
                }else{
                    resCur.next = new ListNode((curB.val+add)%10);
                    resCur = resCur.next;
                    add = (curB.val+add)/10;
                    curB = curB.next;
                }
            }
            if(add > 0){
                resCur.next = new ListNode(add);
                resCur = resCur.next;
            }
            return head.next;
        }
    }
}
