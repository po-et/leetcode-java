package com.home.jianzhi_offer;

import java.util.Arrays;

/**
 * 面试题29. 顺时针打印矩阵
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @see <a href="https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/" />
 * @author Poet
 * @date 2020/5/30
 */
public class Offer_29_PrintSpiralMatrix {

    /**
     * 方法一：模拟
     *
     * solution: https://leetcode.cn/problems/spiral-matrix/solution/luo-xuan-ju-zhen-by-leetcode-solution/
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int[] order = new int[total];
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;

        for (int i = 0; i < total; i++) {
            order[i] = matrix[row][column];
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }


    public static int[] spiralOrder_2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int top = 0, bottom = matrix.length - 1; // 行
        int left = 0, right = matrix[0].length - 1;  // 列

        int[] ret = new int[(bottom + 1) * (right + 1)];
        int direction = 0;
        int index = 0;

        while (left <= right && top <= bottom) {
            // 从左到右
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    ret[index++] = matrix[top][i];
                }
                top++;
            }
            // 从上到下
            if (direction == 1) {
                for (int i = top; i <= bottom; i++) {
                    ret[index++] = matrix[i][right];
                }
                right--;
            }
            // 从右到左
            if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    ret[index++] = matrix[bottom][i];
                }
                bottom--;
            }
            // 从下到上
            if (direction == 3) {
                for (int i = bottom; i >= top; i--) {
                    ret[index++] = matrix[i][left];
                }
                left++;
            }

            direction = (++direction) % 4;
        }

        return ret;
    }


    /**
     * 思路一样（边界收缩！）
     * 更简洁的写法：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/solution/mian-shi-ti-29-shun-shi-zhen-da-yin-ju-zhen-she-di/
     */
    public int[] spiralOrder_MoreClear(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if (++t > b) break;
            for (int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if (l > --r) break;
            for (int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if (t > --b) break;
            for (int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if (++l > r) break;
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] ret = spiralOrder_2(matrix);
        System.out.println(Arrays.toString(ret));
    }
}
