package com.home.leetcode.medium;

/**
 * 64. Minimum Path Sum
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example 1:
 *
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 *
 * @see <a href = "https://leetcode.cn/problems/minimum-path-sum" />
 * @author Poet
 * @date 2022/5/29
 */
public class LC_064_MinimumPathSum {

    /**
     * 官方答案
     * @see <a href="https://leetcode.cn/problems/minimum-path-sum/solution/zui-xiao-lu-jing-he-by-leetcode-solution/" />
     *
     * 状态转移方程：
     * 当 i>0 且 j=0 时，{dp}[i][0]={dp}[i-1][0]+{grid}[i][0]
     * 当 i=0 且 j>0 时，{dp}[0][j]={dp}[0][j-1]+{grid}[0][j]
     * 当 i>0 且 j>0 时，{dp}[i][j]=min({dp}[i-1][j],{dp}[i][j-1])+{grid}[i][j]
     */
    public int minPathSum(int[][] grid) {

        return 0;
    }
}
