package com.home.leetcode.easy;

/**
 * 1252. Cells with Odd Values in a Matrix (奇数值单元格的数目)
 *
 * There is an m x n matrix that is initialized to all 0's. There is also a 2D array indices where each indices[i] = [ri, ci] represents a 0-indexed location to perform some increment operations on the matrix.
 *
 * For each location indices[i], do both of the following:
 *      Increment all the cells on row ri.
 *      Increment all the cells on column ci.
 *      Given m, n, and indices, return the number of odd-valued cells in the matrix after applying the increment to all locations in indices.
 *
 * Example 1:
 * Input: m = 2, n = 3, indices = [[0,1],[1,1]]
 * Output: 6
 * Explanation: Initial matrix = [[0,0,0],[0,0,0]].
 * After applying first increment it becomes [[1,2,1],[0,1,0]].
 * The final matrix is [[1,3,1],[1,3,1]], which contains 6 odd numbers.
 *
 * Example 2:
 * Input: m = 2, n = 2, indices = [[1,1],[0,0]]
 * Output: 0
 * Explanation: Final matrix = [[2,2],[2,2]]. There are no odd numbers in the final matrix.
 *
 * @see <a href="https://leetcode.cn/problems/cells-with-odd-values-in-a-matrix/" />
 * @author Poet
 * @date 2022/7/12
 */
public class LC_1252_CellsWithOddValuesInAMatrix {

    /**
     * 方法一：直接模拟
     *
     * time:  O(q×(m+n)+m×n), 其中 q 表示数组 indices 的长度，m,n 为矩阵的行数与列数。
     * space: O(m×n)，其中 m, n 为矩阵的行数与列数。需要存储矩阵的所有元素。
     */
    public int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];
        // 构建matrix
        for (int[] index : indices) {
            for (int i = 0; i < m; i++) {
                matrix[i][index[1]]++;
            }
            for (int i = 0; i < n; i++) {
                matrix[index[0]][i]++;
            }
        }

        // 遍历得到结果
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isOdd(matrix[i][j])) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean isOdd(int num) {
        return (num & 0x1) == 1;
    }


    /**
     * 方法二：模拟空间优化
     *
     * 由于每次操作只会将一行和一列的数增加 1，因此我们可以使用一个行数组 rows 和列数组 cols 分别记录每一行和每一列被增加的次数。
     *
     * time:  O(q+m×n), 其中 q 表示数组 indices 的长度，m, n 为矩阵的行数与列数。
     * space: O(m+n)，其中 m, n 为矩阵的行数与列数。需要存储矩阵的行数统计与列数统计。
     */
    public int oddCells_2(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int[] index : indices) {
            rows[index[0]]++;
            cols[index[1]]++;
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (((rows[i] + cols[j]) & 1) != 0) {
                    res++;
                }
            }
        }
        return res;
    }

}
