package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix (螺旋矩阵)
 *
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @see <a href="https://leetcode.cn/problems/spiral-matrix/" />
 * @author Poet
 * @date 2022/8/1
 */
public class LC_054_SpiralMatrix {

    /**
     * 方法一：模拟
     *
     * time:  O(mn) 其中 m 和 n 分别是输入矩阵的行数和列数
     * space: O(mn)
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int rows = matrix.length, cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int total = rows * cols;
        int row = 0, col = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;

        for (int i = 0; i < total; i++) {
            res.add(matrix[row][col]);
            visited[row][col] = true;

            int nextRow = row + directions[directionIndex][0];
            int nextCol = col + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || visited[nextRow][nextCol]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            col += directions[directionIndex][1];
        }
        return res;
    }



//    public List<Integer> spiralOrder__(int[][] matrix) {
//        List<Integer> res = new ArrayList<>();
//        int direction = 1;
//        int m = matrix.length;
//        int n = matrix[0].length;
//        int i = 0;
//        int j = 0;
//
//        while (i != j) {
//            if (direction == 1) {
//                while (j >= 0 && j < m) {
//                    res.add(matrix[i][j++]);
//                }
//            }
//            if (direction == 2) {
//                while (i >= 0 && i < n) {
//                    res.add(matrix[i++][j]);
//                }
//            }
//            if (direction == 3) {
//                while (i >= 0 && i < n) {
//                    res.add(matrix[i][j--]);
//                }
//            }
//            if (direction == 4) {
//                while (i >= 0 && i < n) {
//                    res.add(matrix[i--][j]);
//                }
//            }
//
//            direction = direction % 4;
//        }
//
//        return res;
//    }

}
