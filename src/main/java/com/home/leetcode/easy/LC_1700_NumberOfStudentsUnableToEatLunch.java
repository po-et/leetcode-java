package com.home.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 1700. Number of Students Unable to Eat Lunch (无法吃午餐的学生数量)
 *
 * The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers 0 and 1 respectively. All students stand in a queue. Each student either prefers square or circular sandwiches.
 *
 * The number of sandwiches in the cafeteria is equal to the number of students. The sandwiches are placed in a stack. At each step:
 *
 * If the student at the front of the queue prefers the sandwich on the top of the stack, they will take it and leave the queue.
 * Otherwise, they will leave it and go to the queue's end.
 * This continues until none of the queue students want to take the top sandwich and are thus unable to eat.
 *
 * You are given two integer arrays students and sandwiches where sandwiches[i] is the type of the ith sandwich in the stack (i = 0 is the top of the stack) and students[j] is the preference of the jth student in the initial queue (j = 0 is the front of the queue).
 *
 * Return the number of students that are unable to eat.
 *
 *
 * Example 1:
 * Input: students = [1,1,0,0], sandwiches = [0,1,0,1]
 * Output: 0
 * Explanation:
 * - Front student leaves the top sandwich and returns to the end of the line making students = [1,0,0,1].
 * - Front student leaves the top sandwich and returns to the end of the line making students = [0,0,1,1].
 * - Front student takes the top sandwich and leaves the line making students = [0,1,1] and sandwiches = [1,0,1].
 * - Front student leaves the top sandwich and returns to the end of the line making students = [1,1,0].
 * - Front student takes the top sandwich and leaves the line making students = [1,0] and sandwiches = [0,1].
 * - Front student leaves the top sandwich and returns to the end of the line making students = [0,1].
 * - Front student takes the top sandwich and leaves the line making students = [1] and sandwiches = [1].
 * - Front student takes the top sandwich and leaves the line making students = [] and sandwiches = [].
 * Hence all students are able to eat.
 *
 * Example 2:
 * Input: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
 * Output: 3
 *
 * @see <a href="https://leetcode.cn/problems/number-of-students-unable-to-eat-lunch/" />
 * @author Poet
 * @date 2022/10/19
 */
public class LC_1700_NumberOfStudentsUnableToEatLunch {

    /**
     * 方法一：模拟
     *
     * time:  O(n)
     * space: O(1)
     */
    public int countStudents(int[] students, int[] sandwiches) {
        int s1 = Arrays.stream(students).sum();
        int s0 = students.length - s1;
        for (int i = 0; i < sandwiches.length; i++) {
            if (sandwiches[i] == 0 && s0 > 0) {
                s0--;
            } else if (sandwiches[i] == 1 && s1 > 0) {
                s1--;
            } else {
                break;
            }
        }
        return s0 + s1;
    }



    // 模拟方法
    // 自己完成 ac，平铺直叙，不如答案简洁
    public int countStudents_own(int[] students, int[] sandwiches) {
        int n = students.length;
        Deque<Integer> stack1 = new ArrayDeque<>(n);
        for (int student : students) {
            stack1.offer(student);
        }

        for (int i = 0; i < n; i++) {
            if (stack1.peek() == sandwiches[i]) {
                stack1.pop();
            } else {
                int count = 0;
                int len = stack1.size();
                while (stack1.peek() != sandwiches[i] && count < len) {
                    count ++;
                    stack1.offer(stack1.pop());
                }
                if (count == len) {
                    return len;
                }
            }
        }
        return 0;
    }
}
