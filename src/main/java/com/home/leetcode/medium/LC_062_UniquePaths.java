package com.home.leetcode.medium;

/**
 * 62. Unique Paths （不同路径）
 *
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 *
 * Example 1:
 * Input: m = 3, n = 7
 * Output: 28
 *
 * Example 2:
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 *      1. Right -> Down -> Down
 *      2. Down -> Down -> Right
 *      3. Down -> Right -> Down
 *
 * @see <a href="https://leetcode.cn/problems/unique-paths/" />
 * @author Poet
 * @date 2022/5/31
 */
public class LC_062_UniquePaths {

    /**
     * 方法一：动态规划
     *
     * 状态定义：
     *      f(i,j) 表示从左上角走到 (i, j) 的路径数量，其中 i 和 j 的范围分别是 [0, m) 和 [0, n)
     * 状态转移方程：
     *      f(i,j) = f(i−1,j) + f(i,j−1)
     * 初始条件：
     *      f(0,0)=1，即从左上角走到左上角有一种方法
     * 边界条件：
     *      如果 i=0 或者 j=0，那么 f(i-1,j) 并不是一个满足要求的状态，我们需要忽略这一项
     *
     * time:  O(m*n)
     * space: O(m*n)
     */
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];

        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            f[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }

        return f[m - 1][n - 1];
    }
}
