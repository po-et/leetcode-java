package com.home.jianzhi_offer_II;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer II 039. 直方图最大矩形面积
 *
 * 给定非负整数数组 heights ，数组中的数字用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 示例 1:
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 *
 * 示例 2：
 * 输入： heights = [2,4]
 * 输出： 4
 *
 * 注意：本题与主站 84 题相同： https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 *
 * @see <a href="https://leetcode.cn/problems/0ynMMM" />
 * @author Poet
 * @date 2023/3/25
 */
public class Offer_II_039_LargestRectangleInHistogram {

    /**
     * 方法一：单调栈
     *
     * time:  O(n)
     * space: O(n)
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }
        return res;
    }



    /**
     * 暴力解法（超出时间限制）
     * time:  O(n^2)
     */
    public int largestRectangleArea_bruteForce(int[] heights) {
        int res = 0;
        int n = heights.length;
        // 枚举左边界
        for (int i = 0; i < n; i++) {
            int minHeight = heights[i];
            // 枚举右边界
            for (int j = i; j < n; j++) {
                // 确定高度
                minHeight = Math.min(minHeight, heights[j]);
                // 计算面积
                res = Math.max(res, minHeight * (j - i + 1));
            }
        }
        return res;
    }

}
