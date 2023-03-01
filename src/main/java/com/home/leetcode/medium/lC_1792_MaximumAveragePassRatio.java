package com.home.leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1792. Maximum Average Pass Ratio （最大平均通过率）
 *
 * There is a school that has classes of students and each class will be having a final exam. You are given a 2D integer array classes, where classes[i] = [passi, totali]. You know beforehand that in the ith class, there are totali total students, but only passi number of students will pass the exam.
 *
 * You are also given an integer extraStudents. There are another extraStudents brilliant students that are guaranteed to pass the exam of any class they are assigned to. You want to assign each of the extraStudents students to a class in a way that maximizes the average pass ratio across all the classes.
 *
 * The pass ratio of a class is equal to the number of students of the class that will pass the exam divided by the total number of students of the class. The average pass ratio is the sum of pass ratios of all the classes divided by the number of the classes.
 *
 * Return the maximum possible average pass ratio after assigning the extraStudents students. Answers within 10-5 of the actual answer will be accepted.
 *
 * Example 1:
 * Input: classes = [[1,2],[3,5],[2,2]], extraStudents = 2
 * Output: 0.78333
 * Explanation: You can assign the two extra students to the first class. The average pass ratio will be equal to (3/4 + 3/5 + 2/2) / 3 = 0.78333.
 *
 * Example 2:
 * Input: classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
 * Output: 0.53485
 *
 * @see <a href="https://leetcode.cn/problems/maximum-average-pass-ratio/" />
 * @author Poet
 * @date 2023/2/19
 */
public class lC_1792_MaximumAveragePassRatio {

    /**
     * 优先队列
     *
     * 思路：由于班级总数不会变化，因此题目所求「最大化平均通过率」等价于「最大化总通过率」
     *
     * 化简后可得：
     * ({total}_j + 1) * ({total}_j) * ({total}_i - {pass}_i) < ({total}_i + 1) * ({total}_i) * ({total}_j - {pass}_j)
     *
     * time:  O((n+m)logn)
     * space: O(n)
     */
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // 构造最大推
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                long var1 = (long) (b[1] + 1) * b[1] * (a[1] - a[0]);
                long var2 = (long) (a[1] + 1) * a[1] * (b[1] - b[0]);
                if (var1 == var2) {
                    return 0;
                }
                return var1 < var2 ? 1 : -1;
            }
        });

        for (int[] cls : classes) {
            pq.offer(cls);
        }

        for (int i = 0; i < extraStudents; i++) {
            int[] poll = pq.poll();
            pq.offer(new int[]{poll[0] + 1, poll[1] + 1});
        }

        double res = 0;
        for (int i = 0; i < classes.length; i++) {
            int[] poll = pq.poll();
            res += 1.0 * poll[0] / poll[1];
        }
        return res / classes.length;
    }
}
