package JZoffer;

import java.util.Stack;

public class JZ20 {

    Stack<Integer> stack = new Stack<Integer>();//所有值的栈
    Stack<Integer> minStack = new Stack<Integer>();//最小值栈

    public void push(int node) {
        stack.push(node);//任何值都放入该栈中

        if(minStack.empty() || minStack.peek() > node){

            minStack.push(node);
        }
    }

    public void pop() {

        if(stack.peek() == minStack.peek()){
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
