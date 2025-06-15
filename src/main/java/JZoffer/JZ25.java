package JZoffer;

import dto.RandomListNode;

public class JZ25 {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null){
            return null;
        }

        RandomListNode tmp = pHead;
        RandomListNode clone = new RandomListNode(tmp.label);
        RandomListNode tmp2 = clone;

        //创建克隆链表
        while(tmp != null){
            if(tmp.next != null){
                RandomListNode next = new RandomListNode(tmp.next.label);
                tmp2.next = next;
                tmp2 = next;
            }
            tmp = tmp.next;
        }

        //添加随机信息
        tmp2 = clone;
        tmp = pHead;
        while(tmp2 != null){

            RandomListNode next1 = pHead;
            RandomListNode next2 = clone;

            int i = random2next(tmp.random, next1);

            while(i >0){
                i--;
                next2 = next2.next;
            }

            tmp2.random = next2;

            tmp = tmp.next;
            tmp2 = tmp2.next;
        }

        return clone;
    }

    public int random2next(RandomListNode node, RandomListNode head){
        int next = 0;
        while(head != node){
            next ++;
            head = head.next;
        }
        return next;
    }
}
