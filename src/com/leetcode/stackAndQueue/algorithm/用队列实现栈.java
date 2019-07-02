package com.leetcode.stackAndQueue.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/5/13 10:56
 */
public class 用队列实现栈 {

    class MyStack {
        private Queue<Integer> queue1;
        private Queue<Integer> queue2;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue1.offer(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            int res = queue1.poll();
            while (!queue2.isEmpty()) {
                queue1.offer(queue2.poll());
            }
            return res;
        }

        /**
         * Get the top element.
         */
        public int top() {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            int res = queue1.poll();
            while (!queue2.isEmpty()) {
                queue1.offer(queue2.poll());
            }
            queue1.offer(res);
            return res;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue1.isEmpty() && queue1.isEmpty();
        }
    }

}
