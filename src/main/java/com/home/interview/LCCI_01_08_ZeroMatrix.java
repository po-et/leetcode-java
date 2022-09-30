package com.home.interview;

/**
 * 面试题 01.08. Zero Matrix LCCI (零矩阵)
 *
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 *
 * Example 1:
 * Input:
 *      [
 *        [1,1,1],
 *        [1,0,1],
 *        [1,1,1]
 *      ]
 * Output:
 *      [
 *        [1,0,1],
 *        [0,0,0],
 *        [1,0,1]
 *      ]
 *
 * Example 2:
 * Input:
 *      [
 *        [0,1,2,0],
 *        [3,4,5,2],
 *        [1,3,1,5]
 *      ]
 * Output:
 *      [
 *        [0,0,0,0],
 *        [0,4,5,0],
 *        [0,3,1,0]
 *      ]
 *
 * @see <a href="https://leetcode.cn/problems/zero-matrix-lcci/" />
 * @author Poet
 * @date 2022/9/30
 */
public class LCCI_01_08_ZeroMatrix {

    /**
     * 方法一：使用标记数组
     *
     * 我们可以用两个标记数组分别记录每一行和每一列是否有零出现。
     *
     * time:  O(mn)
     * space: O(m+n)
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
