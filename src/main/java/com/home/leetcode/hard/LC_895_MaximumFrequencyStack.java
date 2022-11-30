package com.home.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 895. Maximum Frequency Stack (最大频率栈)
 *
 * Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.
 *
 * Implement the FreqStack class:
 *  - FreqStack() constructs an empty frequency stack.
 *  - void push(int val) pushes an integer val onto the top of the stack.
 *  - int pop() removes and returns the most frequent element in the stack.
 *      If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
 *
 * Example 1:
 * Input
 *  ["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
 *  [[], [5], [7], [5], [7], [4], [5], [], [], [], []]
 * Output
 *  [null, null, null, null, null, null, null, 5, 7, 5, 4]
 * Explanation
 *  FreqStack freqStack = new FreqStack();
 *  freqStack.push(5); // The stack is [5]
 *  freqStack.push(7); // The stack is [5,7]
 *  freqStack.push(5); // The stack is [5,7,5]
 *  freqStack.push(7); // The stack is [5,7,5,7]
 *  freqStack.push(4); // The stack is [5,7,5,7,4]
 *  freqStack.push(5); // The stack is [5,7,5,7,4,5]
 *  freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
 *  freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
 *  freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
 *  freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
 *
 * @see <a href="https://leetcode.cn/problems/maximum-frequency-stack/" />
 * @author Poet
 * @date 2022/11/30
 */
public class LC_895_MaximumFrequencyStack {

    /**
     * 方法一：哈希表和栈
     *
     * 我们可以考虑将栈序列分解为多个频率不同的栈序列，每个栈维护同一频率的元素。
     * 当元素入栈时频率增加，将元素加入到更高频率的栈中，低频率栈中的元素不需要出栈。当元素出栈时，将频率最高的栈的栈顶元素出栈即可。
     */
    class FreqStack {

        Map<Integer, Integer> freq;
        Map<Integer, Deque<Integer>> group;
        int maxFreq;

        public FreqStack() {
            freq = new HashMap<>();
            group = new HashMap<>();
            maxFreq = 0;
        }

        public void push(int val) {
            freq.put(val, freq.getOrDefault(val, 0) + 1);
            group.putIfAbsent(freq.get(val), new ArrayDeque<>());
            group.get(freq.get(val)).push(val);
            maxFreq = Math.max(maxFreq, freq.get(val));
        }

        public int pop() {
            int val = group.get(maxFreq).peek();
            freq.put(val, freq.get(val) - 1);
            group.get(maxFreq).pop();
            if (group.get(maxFreq).isEmpty()) {
                maxFreq--;
            }
            return val;
        }
    }

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
}
