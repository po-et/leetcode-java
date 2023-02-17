package com.home.leetcode.medium;

/**
 * 1139. Largest 1-Bordered Square (最大的以 1 为边界的正方形)
 *
 * Given a 2D grid of 0s and 1s, return the number of elements in the largest square subgrid that has all 1s on its border,
 * or 0 if such a subgrid doesn't exist in the grid.
 *
 * Example 1:
 * Input: grid = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 9
 *
 * Example 2:
 * Input: grid = [[1,1,0,0]]
 * Output: 1
 *
 * @see <a href="https://leetcode.cn/problems/largest-1-bordered-square/" />
 * @author Poet
 * @date 2023/2/17
 */
public class LC_1139_Largest1BorderedSquare {

    // 参考答案

    /**
     * 方法一：动态规划
     */
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] left = new int[m + 1][n + 1];
        int[][] up = new int[m + 1][n + 1];
        int maxBorder = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i - 1][j - 1] == 1) {
                    left[i][j] = left[i][j - 1] + 1;
                    up[i][j] = up[i - 1][j] + 1;
                    int border = Math.min(left[i][j], up[i][j]);
                    while (left[i - border + 1][j] < border || up[i][j - border + 1] < border) {
                        border--;
                    }
                    maxBorder = Math.max(maxBorder, border);
                }
            }
        }
        return maxBorder * maxBorder;
    }
}
