package JZoffer;

import dto.ListNode;

public class JZ56 {
   /* //重复的只保留一个
    public ListNode deleteDuplication(ListNode pHead)
    {

        if(pHead == null || pHead.next == null){
            return pHead;
        }

        ListNode pre = pHead;
        ListNode tmp = pHead.next;

        while (tmp != null){
            if(pre.val == tmp.val && tmp.next != null){
                tmp = tmp.next;
            }else if(pre.val == tmp.val && tmp.next == null){
                pre.next = null;
                tmp = tmp.next;
            }else if(pre.val != tmp.val && pre.next != tmp){
                pre.next = tmp;
                pre = pre.next;
                tmp = tmp.next;
            }else if(pre.val != tmp.val && pre.next == tmp){
                pre = tmp;
                tmp = tmp.next;
            }
        }

        return pHead;
    }*/

   //重复的不保留
    public ListNode deleteDuplication(ListNode pHead)
    {

        if(pHead == null || pHead.next == null){
            return pHead;
        }

        ListNode newHead = new ListNode(0);//添加新的头节点，防止第一个和第二就重复的情况
        newHead.next = pHead;

        ListNode pre = newHead;
        ListNode tmp = newHead.next;


        while (tmp != null){
            if(tmp.next != null && tmp.val == tmp.next.val){
                //找到最后一个相同的结点
                while(tmp.next != null && tmp.val == tmp.next.val){
                    tmp = tmp.next;
                }
                pre.next = tmp.next;
                tmp = tmp.next;
            }else {
               pre = pre.next;
               tmp = tmp.next;
            }
        }

        return newHead.next;
    }
}
