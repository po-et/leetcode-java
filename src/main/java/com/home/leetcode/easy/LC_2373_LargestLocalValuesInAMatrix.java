package com.home.leetcode.easy;

/**
 * 2373. Largest Local Values in a Matrix (矩阵中的局部最大值)
 *
 * You are given an n x n integer matrix grid.
 *
 * Generate an integer matrix maxLocal of size (n - 2) x (n - 2) such that:
 *
 * maxLocal[i][j] is equal to the largest value of the 3 x 3 matrix in grid centered around row i + 1 and column j + 1.
 * In other words, we want to find the largest value in every contiguous 3 x 3 matrix in grid.
 *
 * Return the generated matrix.
 *
 * Example 1:
 * Input: grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
 * Output: [[9,9],[8,6]]
 * Explanation: The diagram above shows the original matrix and the generated matrix.
 * Notice that each value in the generated matrix corresponds to the largest value of a contiguous 3 x 3 matrix in grid.
 *
 * Example 2:
 * Input: grid = [[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]
 * Output: [[2,2,2],[2,2,2],[2,2,2]]
 * Explanation: Notice that the 2 is contained within every contiguous 3 x 3 matrix in grid.
 *
 * @see <a href="https://leetcode.cn/problems/largest-local-values-in-a-matrix/" />
 * @author Poet
 * @date 2023/3/1
 */
public class LC_2373_LargestLocalValuesInAMatrix {

    /**
     * 两遍遍历
     *
     * time:  O(n^2)
     * space: O(1)
     */
    public int[][] largestLocal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] target = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 2; j++) {
                target[i][j] = max(grid[i][j], grid[i][j + 1], grid[i][j + 2]);
            }
        }

        int[][] res = new int[m - 2][n - 2];
        for (int j = 0; j < n - 2; j++) {
            for (int i = 0; i < m - 2; i++) {
                res[i][j] = max(target[i][j], target[i + 1][j], target[i + 2][j]);
            }
        }

        return res;
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }


    /**
     * 方法一：遍历 （官方题解）
     *
     * time:  O(n^2)
     * space: O(1)
     */
    public int[][] largestLocal_official(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        res[i][j] = Math.max(res[i][j], grid[x][y]);
                    }
                }
            }
        }
        return res;
    }
}
