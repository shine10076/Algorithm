package com.offer.algorithm;

import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/4/8 22:05
 */
public class 两个栈实现一个队列 {

    class queueByStack{
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public void push(int node)
        {
            stack1.push(node);
        }

        public int pop(){
            if(!stack2.isEmpty())
            {
                return stack2.pop();
            }
            else if(!stack1.isEmpty() && stack2.isEmpty())
            {
                while(!stack1.isEmpty())
                {
                    stack2.push(stack1.pop());
                }
               return stack2.pop();
            }
            else {
                return 0;
            }
        }
    }

}
