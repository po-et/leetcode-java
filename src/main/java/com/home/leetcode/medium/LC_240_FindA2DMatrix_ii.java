package com.home.leetcode.medium;

/**
 * 240. Search a 2D Matrix II
 *
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 * @see <a href="https://leetcode.cn/problems/search-a-2d-matrix-ii" />
 * @author poet
 * @date 2022/6/9
 */
public class LC_240_FindA2DMatrix_ii {

    /**
     * 方法一：Z字形查找
     *
     * time:  O(m+n)
     * space: O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        int row = 0;                // 从第一行开始
        int col = colLength - 1;    // 从最后一列开始

        while (row < rowLength && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

}
