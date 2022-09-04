package com.home.leetcode.easy;

/**
 * 1582. Special Positions in a Binary Matrix (二进制矩阵中的特殊位置)
 *
 * Given an m x n binary matrix mat, return the number of special positions in mat.
 *
 * A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).
 *
 * Example 1:
 * Input: mat = [[1,0,0],[0,0,1],[1,0,0]]
 * Output: 1
 * Explanation: (1, 2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0.
 *
 * Example 2:
 * Input: mat = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 * Explanation: (0, 0), (1, 1) and (2, 2) are special positions.
 *
 * @see <a href="https://leetcode.cn/problems/special-positions-in-a-binary-matrix/" />
 * @author Poet
 * @date 2022/9/4
 */
public class LC_1582_SpecialPositionsInABinaryMatrix {

    /**
     * 方法一：暴力法（自己写的）
     */
    public int numSpecial(int[][] mat) {
        int m  = mat.length;
        int n = mat[0].length;
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }

                boolean flag = true;
                for (int k = 0; k < n; k++) {
                    if (k != j && mat[i][k] == 1) {
                        flag = false;
                        break;
                    }
                }
                for (int k = 0; k < m; k++) {
                    if (k != i && mat[k][j] == 1) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 方法二：模拟 (预处理出每一行和列的和，来快速的得到每一行和列中的 1 的个数)
     *
     * time:  O(m×n) 其中 m 为矩阵 mat 的行数，n 为矩阵 mat 的列数
     * space: O(m+n) 主要为预处理每一行和列的空间开销
     */
    public int numSpecial_2(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rowSum = new int[m];
        int[] colSum = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += mat[i][j];
                colSum[j] += mat[i][j];
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }

}
