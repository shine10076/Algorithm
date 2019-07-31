package com.offer.algorithm;

import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/7/31 21:02
 */
public class 包含min函数的栈 {

        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();

        public void push(int node) {
            stack.push(node);
            if(minStack.isEmpty() || minStack.peek()>=node)
            {
                minStack.push(node);
            }
        }

        public void pop() {
            if (stack.isEmpty()) return;
            if(minStack.peek() == stack.peek() )
            {
                minStack.pop();
            }
            stack.pop();
        }

        public int top() {
            if(!stack.isEmpty())
            {
                return stack.peek();
            }
            return -1;
        }

        public int min() {
            if(!minStack.isEmpty())
            {
                return minStack.peek();
            }
            return -1;
        }
}
