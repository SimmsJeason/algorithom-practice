package CM;

import dto.ListNode;

public class CM10 {
    public boolean removeNode(ListNode pNode) {
       if(pNode == null || pNode.next == null){
           return false;
       }

       pNode.val = pNode.next.val;
       pNode.next = pNode.next.next;

       return true;
    }
}
