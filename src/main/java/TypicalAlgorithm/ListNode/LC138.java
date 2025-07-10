package TypicalAlgorithm.ListNode;

import dto.RandomListNode;

import java.util.HashMap;

/**
 * 随机链表的复制
 */
public class LC138 {
    /**
     * 回溯 + 哈希表
     * 哈希表用来记录创建的节点，
     * 回溯来链接当前节点的后继节点和随机节点
     * @param head
     * @return
     */
    HashMap<RandomListNode, RandomListNode> nodeMap = new HashMap<>();

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        if (!nodeMap.containsKey(head)) {
            RandomListNode copy = new RandomListNode(head.label);
            nodeMap.put(head, copy); //建立新旧节点映射
            copy.next = copyRandomList(head.next); //后继
            copy.random = copyRandomList(head.random); //随机节点
            //nodeMap.put(copy, copy);
        }
        return nodeMap.get(head);
    }
}
