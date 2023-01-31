package com.home.leetcode.easy;

/**
 * 2319. Check if Matrix Is X-Matrix (判断矩阵是否是一个 X 矩阵)
 *
 * A square matrix is said to be an X-Matrix if both of the following conditions hold:
 *
 * All the elements in the diagonals of the matrix are non-zero.
 * All other elements are 0.
 * Given a 2D integer array grid of size n x n representing a square matrix, return true if grid is an X-Matrix. Otherwise, return false.
 *
 * Example 1:
 * Input: grid = [[2,0,0,1],[0,3,1,0],[0,5,2,0],[4,0,0,2]]
 * Output: true
 * Explanation: Refer to the diagram above.
 * An X-Matrix should have the green elements (diagonals) be non-zero and the red elements be 0.
 * Thus, grid is an X-Matrix.
 *
 * Example 2:
 * Input: grid = [[5,7,0],[0,3,1],[0,5,0]]
 * Output: false
 * Explanation: Refer to the diagram above.
 * An X-Matrix should have the green elements (diagonals) be non-zero and the red elements be 0.
 * Thus, grid is not an X-Matrix.
 *
 * @see <a href="https://leetcode.cn/problems/check-if-matrix-is-x-matrix/" />
 * @author Poet
 * @date 2023/1/31
 */
public class LC_2319_CheckIfMatrixIsXMatrix {

    /**
     * 方法一：数学
     *
     * time:  O(n^2)
     * space: O(1)
     */
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isDiagonal(i, j, n) && grid[i][j] == 0) {
                    return false;
                }
                if (!isDiagonal(i, j, n) && grid[i][j] != 0) {
                    return false;
                }
            }

        }
        return true;
    }

    private boolean isDiagonal(int i, int j, int len) {
        return i == j || (i + j + 1) == len;
    }
}