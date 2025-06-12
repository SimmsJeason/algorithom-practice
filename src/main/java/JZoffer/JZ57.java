package JZoffer;

import dto.TreeLinkNode;

import java.nio.channels.spi.SelectorProvider;

public class JZ57 {

    /**
     分成两大类：1、有右子树的，那么下个结点就是右子树最左边的点；
     2、没有右子树的，也可以分成两类，
     a)是父节点左孩子，那么父节点就是下一个节点 ；
     b)是父节点的右孩子找他的父节点的父节点的父节点...直到当前结点是其父节点的左孩子位置。
     如果没有eg：M，那么他就是尾节点。
     */

    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null){
            return null;
        }

        if(pNode.right != null){
            pNode = pNode.right;

            if(pNode.left != null){
                while(pNode.left != null){
                    pNode = pNode.left;
                }
                return pNode;
            }else {
                return pNode;
            }
        }else {
            if(pNode.next != null){
                if(pNode == pNode.next.left){//该结点为父节点的左孩子
                    return pNode.next;
                }else{//该结点为父节点的右孩子
                    while (pNode.next != null){

                        if(pNode == pNode.next.left) {//该结点为父节点的左孩子
                            return pNode.next;
                        }else {
                            pNode = pNode.next;
                        }
                    }
                }
            }
        }

        return pNode.next;
    }



}
