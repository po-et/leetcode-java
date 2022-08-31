package com.home.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 946. Validate Stack Sequences (验证栈序列)
 *
 * Given two integer arrays pushed and popped each with distinct values, return true if this could have been the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.
 *
 * Example 1:
 *
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * Output: true
 * Explanation: We might do the following sequence:
 * push(1), push(2), push(3), push(4),
 * pop() -> 4,
 * push(5),
 * pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * Example 2:
 *
 * Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * Output: false
 * Explanation: 1 cannot be popped before 2.
 *
 * @see <a href="https://leetcode.cn/problems/validate-stack-sequences/" />
 * @author Poet
 * @date 2022/8/31
 */
public class LC_946_ValidateStackSequences {

    /**
     * 方法一：栈模拟
     *
     * time:  O(n)
     * space: O(n)
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        int n = popped.length;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[index] && index < n) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

}
