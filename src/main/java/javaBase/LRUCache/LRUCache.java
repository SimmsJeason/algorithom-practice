package javaBase.LRUCache;

import java.util.HashMap;

// 时间复杂度：get、set方法都达到O(1)
// 空间复杂度：O(capacity)
class LRUCache {
    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        Node(int key, int value, Node pre, Node next) {
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }

    private HashMap<Integer, Node> mMap;
    private int mCapacity;
    private Node mHead;
    private Node mTail;

    public LRUCache(int capacity) {
        this.mCapacity = capacity;
        mMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = mMap.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToTail(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node result = mMap.get(key);
        Node newNode = new Node(key, value, null, null);
        if (result == null) {
            // 队列中不存在该元素
            if (mMap.size() < mCapacity) {
                // 队列没有满
                if (mMap.size() == 0) {
                    // 直接插到队头
                    mHead = newNode;
                    mTail = newNode;
                    mMap.put(key, newNode);
                } else {
                    // 直接插到队尾
                    mTail.next = newNode;
                    newNode.pre = mTail;
                    mTail = newNode;
                    mMap.put(key, newNode);
                }
            } else {
                // 队列已经满了
                Node oldNode = removeHead();
                mMap.remove(oldNode.key);

                addLast(newNode);
                mMap.put(key, newNode);
            }
        } else {
            result.value = value;
            // 队列中存在该元素
            moveToTail(result);
        }
    }

    private void moveToTail(Node node) {
        if (mTail != node) {
            Node pre = node.pre;
            Node next = node.next;
            if (pre != null) {
                pre.next = next;
            }
            if (next != null) {
                next.pre = pre;
                if (next.pre == null) {
                    mHead = next;
                }
            }
            if (mTail != null) {
                mTail.next = node;
                node.next = null;
                node.pre = mTail;
            }
            mTail = node;
        }
    }

    private void addLast(Node newNode) {
        if (mTail == null) {
            mHead = newNode;
        } else {
            mTail.next = newNode;
            newNode.pre = mTail;
        }
        mTail = newNode;
    }

    private Node removeHead() {
        Node deleteNode = mHead;
        if (mHead != null) {
            Node next = mHead.next;
            if (next != null) {
                next.pre = null;
            } else {
                mTail = null;
            }
            mHead = next;
        }
        return deleteNode;
    }

}
