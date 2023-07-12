package com.home.leetcode.medium;

import java.util.Arrays;

/**
 * 931. Minimum Falling Path Sum (下降路径最小和)
 *
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 *
 * A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 *
 * Example 1:
 * Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * Output: 13
 * Explanation: There are two falling paths with a minimum sum as shown.
 *
 * Example 2:
 * Input: matrix = [[-19,57],[-40,-5]]
 * Output: -59
 * Explanation: The falling path with a minimum sum is shown.
 *
 * @see <a href="https://leetcode.cn/problems/minimum-falling-path-sum/" />
 * @author Poet
 * @date 2023/7/13
 */
public class LC_931_MinimumFallingPathSum {

    /**
     * 动态规划
     *
     * time:  O(N^2)
     * space: O(N^2)
     */
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        // 初始化
        System.arraycopy(matrix[0], 0, dp[0], 0, n);

        // 递推
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int mn = dp[i - 1][j];
                if (j > 0) {
                    mn = Math.min(mn, dp[i - 1][j - 1]);
                }
                if (j < n - 1) {
                    mn = Math.min(mn, dp[i - 1][j + 1]);
                }
                dp[i][j] = mn + matrix[i][j];
            }
        }

        // 返回最后一行最小的值
        return Arrays.stream(dp[n - 1]).min().getAsInt();
    }

}
