package com.home.jianzhi_offer_II;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer II 040. 矩阵中最大的矩形
 *
 * 给定一个由 0 和 1 组成的矩阵 matrix ，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 注意：此题 matrix 输入格式为一维 01 字符串数组。
 *
 * 示例 1：
 * 输入：matrix = ["10100","10111","11111","10010"]
 * 输出：6
 * 解释：最大矩形如上图所示。
 *
 * 示例 2：
 * 输入：matrix = []
 * 输出：0
 *
 * 示例 3：
 * 输入：matrix = ["0"]
 * 输出：0
 *
 * 示例 4：
 * 输入：matrix = ["1"]
 * 输出：1
 *
 * 示例 5：
 * 输入：matrix = ["00"]
 * 输出：0
 *
 * 注意：本题与主站 85 题相同（输入参数格式不同）： https://leetcode-cn.com/problems/maximal-rectangle/
 *
 * @see <a href="https://leetcode.cn/problems/PLYXKQ/" />
 * @author Poet
 * @date 2023/3/25
 */
public class Offer_II_040_MaximalRectangle {

    // 看答案
    /**
     * 单调栈
     *
     * Offer_II_039_LargestRectangleInHistogram 的单调栈进阶版
     */
    public int maximalRectangle(String[] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length();
        int[][] left = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i].charAt(j) == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int res = 0;
        for (int j = 0; j < n; j++) {   // 对于每一列，使用基于柱状图的方法
            int[] up = new int[m];
            int[] down = new int[m];

            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < m; i++) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }

            stack.clear();
            for (int i = m - 1; i >= 0; i--) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? m : stack.peek();
                stack.push(i);
            }

            for (int i = 0; i < m; i++) {
                int height = down[i] - up[i] - 1;
                int area = height * left[i][j];
                res = Math.max(res, area);
            }
        }

        return res;
    }

}
