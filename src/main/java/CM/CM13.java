package CM;

import dto.ListNode;

public class CM13 {
    public boolean isPalindrome(ListNode pHead) {
        // write code here
        if(pHead == null){
            return false;
        }

        StringBuffer sb = new StringBuffer();

        ListNode tmp = pHead;
        while (tmp != null){
            sb.append(Integer.toString(tmp.val));
            tmp = tmp.next;
        }

        String str = sb.toString();
        String reverse = sb.reverse().toString();

        if(reverse.equals(str)){
            return true;
        }else {
            return false;
        }
    }
}
