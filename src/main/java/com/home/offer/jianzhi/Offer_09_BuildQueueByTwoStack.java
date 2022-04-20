package com.home.offer.jianzhi;

import java.util.Stack;

/**
 * 面试题09. 用两个栈实现队列
 *
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * @author Poet
 * @date 2020/5/20
 */
public class Offer_09_BuildQueueByTwoStack {

    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */


    /**
     * 更好的思路：只转移一次，stack为空时才继续转移
     */
    class CQueue {
        private Stack<Integer> dataStack ;
        private Stack<Integer> tmpStack ;

        public CQueue() {
            dataStack = new Stack<>();
            tmpStack = new Stack<>();
        }

        public void appendTail(int value) {
            dataStack.push(value);
        }

        public int deleteHead() {
            if (dataStack.isEmpty() && tmpStack.isEmpty()) {
                return -1;
            }

            if (tmpStack.isEmpty()) {
                while (!dataStack.isEmpty()) {
                    tmpStack.push(dataStack.pop());
                }
            }
            return tmpStack.pop();
        }
    }

}
