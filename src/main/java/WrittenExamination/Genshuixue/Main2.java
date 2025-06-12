package WrittenExamination.Genshuixue;

import dto.ListNode;

public class Main2 {
    public static void main(String[] args) {

    }

    ListNode getCommon(ListNode headA, ListNode headB) {

        if(headA == null || headB == null)return null;
        ListNode lA = headA;
        ListNode lB= headB;

        while(lA != null && lB != null){
            if(lA == lB){
                return lA;
            }
            if(lA == null && lB != null){
                lA = headB;
                lB = lB.next;
                continue;
            }
            if(lB == null && lA != null){
                lB = headA;
                lA = lA.next;
                continue;
            }
            lA = lA.next;
            lB = lB.next;
        }

        return null;
    }
}
