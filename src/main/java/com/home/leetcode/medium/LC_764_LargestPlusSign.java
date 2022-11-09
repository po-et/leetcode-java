package com.home.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 764. Largest Plus Sign (最大加号标志)
 *
 * You are given an integer n. You have an n x n binary grid grid with all values initially 1's except for some indices given in the array mines.
 * The ith element of the array mines is defined as mines[i] = [xi, yi] where grid[xi][yi] == 0.
 *
 * Return the order of the largest axis-aligned plus sign of 1's contained in grid. If there is none, return 0.
 *
 * An axis-aligned plus sign of 1's of order k has some center grid[r][c] == 1 along with four arms of length k - 1 going up, down, left, and right, and made of 1's.
 * Note that there could be 0's or 1's beyond the arms of the plus sign, only the relevant area of the plus sign is checked for 1's.
 *
 * Example 1:
 * Input: n = 5, mines = [[4,2]]
 * Output: 2
 * Explanation: In the above grid, the largest plus sign can only be of order 2. One of them is shown.
 *
 * Example 2:
 * Input: n = 1, mines = [[0,0]]
 * Output: 0
 * Explanation: There is no plus sign, so return 0.
 *
 * @see <a href="https://leetcode.cn/problems/largest-plus-sign/" />
 * @author Poet
 * @date 2022/11/9
 */
public class LC_764_LargestPlusSign {

    /* --- 这道题来自：Weekly Contest 67 --- */

    // 参考答案

    /**
     * 动态规划
     */
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], n);
        }
        Set<Integer> banned = new HashSet<Integer>();
        for (int[] vec : mines) {
            banned.add(vec[0] * n + vec[1]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            /* left */
            for (int j = 0; j < n; j++) {
                if (banned.contains(i * n + j)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }
            count = 0;
            /* right */
            for (int j = n - 1; j >= 0; j--) {
                if (banned.contains(i * n + j)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            /* up */
            for (int j = 0; j < n; j++) {
                if (banned.contains(j * n + i)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[j][i] = Math.min(dp[j][i], count);
            }
            count = 0;
            /* down */
            for (int j = n - 1; j >= 0; j--) {
                if (banned.contains(j * n + i)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[j][i] = Math.min(dp[j][i], count);
                ans = Math.max(ans, dp[j][i]);
            }
        }
        return ans;
    }

}
