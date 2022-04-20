package com.home.offer.jianzhi;

import java.util.Stack;

/**
 * 面试题30. 包含min函数的栈
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 * @author Poet
 * @date 2020/5/30
 */
public class Offer_30_MinStack {

    static class MinStack {

        private Stack<Integer> stack;
        private Stack<Integer> helpStack;
        private Integer minVal;

        public MinStack() {
            stack = new Stack<>();
            helpStack = new Stack<>();
            minVal = Integer.MAX_VALUE;
        }

        public void push(int x) {
            if (x < minVal) {
                minVal = x;
            }
            stack.push(x);
        }

        public void pop() {
            int pop = stack.pop();
            if (pop == minVal) {
                int minTmp = Integer.MAX_VALUE;
                while (!stack.isEmpty()) {
                    minTmp = Math.min(stack.peek(), minTmp);
                    helpStack.push(stack.pop());
                }
                minVal = minTmp;
                while (!helpStack.isEmpty()) {
                    stack.push(helpStack.pop());
                }
            }
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return minVal;
        }
    }


    /**
     * Better Solution!!!
     *
     * 建立辅助栈：辅助栈中存储原栈中所有【非严格降序】的元素
     * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/solution/mian-shi-ti-30-bao-han-minhan-shu-de-zhan-fu-zhu-z/
     */
    class MinStack_Better {
        Stack<Integer> A, B;
        public MinStack_Better() {
            A = new Stack<>();
            B = new Stack<>();
        }
        public void push(int x) {
            A.add(x);
            if(B.empty() || B.peek() >= x)
                B.add(x);
        }
        public void pop() {
            if(A.pop().equals(B.peek()))
                B.pop();
        }
        public int top() {
            return A.peek();
        }
        public int min() {
            return B.peek();
        }
    }



    // test case
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);

        minStack.pop();
        System.out.println(minStack.min());

        minStack.pop();
        System.out.println(minStack.min());

        minStack.pop();
        System.out.println(minStack.min());
    }

}
