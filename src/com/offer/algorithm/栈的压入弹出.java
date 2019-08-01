package com.offer.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/8/1 12:46
 */
public class 栈的压入弹出 {

    /**
     * 压入栈的数字均不相等！
     * @param pushA ：压入
     * @param popA ：弹出
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {

        Stack<Integer> stack = new Stack<Integer>() ;
        int count = 0;
        for(int i=0;i<pushA.length;i++)
        {
            while (stack.isEmpty() || popA[i]!=stack.peek())
            {
                if(count<pushA.length)
                {
                    stack.push(pushA[count++]);
                }
                else
                {
                    return false;
                }
            }
            stack.pop();
        }

        return true;
    }

}
