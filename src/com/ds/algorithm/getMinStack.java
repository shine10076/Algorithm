package com.ds.algorithm;

import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/5/3 15:17
 */
public class getMinStack {

    public static class minStack {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public minStack(Stack<Integer> stackData, Stack<Integer> stackMin) {
            this.stackData = stackData;
            this.stackMin = stackMin;
        }

        public void push(int newNum) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum <= this.getmin()) {
                this.stackMin.push(newNum);
            }
            this.stackData.push(newNum);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            int value = this.stackData.pop();
            if (value == this.getmin()) {
                this.stackMin.pop();
            }
            return value;
        }

        public int getmin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }
    }
}
