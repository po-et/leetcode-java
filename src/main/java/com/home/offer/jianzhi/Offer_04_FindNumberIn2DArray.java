package com.home.offer.jianzhi;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题04. 二维数组中的查找
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 *
 * @author Poet
 * @date 2020/5/20
 */
public class Offer_04_FindNumberIn2DArray {

    /**
     * 首先选取数组中右上角的数字:
     * - 如果该数字等于要查找的数字，查找过程结束；
     * - 如果该数字大于要查找的数字，剔除这个数字所在的列；
     * - 如果该数字小于要查找的数字，剔除这个数字所在的行。
     *
     * ==> 也就是说如果要查找的数字不在数组的右上角，则每一次都在数组的查找范围中剔除一行或者一列，这样每一步都可以缩小查找的范围，直到找到要查找的数字，或者查找范围为空。
     *
     * @see <a href="https://www.cnblogs.com/edisonchou/p/4737944.html" />
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        int row = 0;    // 从第一行开始
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




    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        // valid
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        return findNumberRecursive(matrix, rowLength, colLength, 0, 0, target);
    }

    /**
     * （递归方式）
     * NOT AC !
     * 执行结果： 超出时间限制
     */
    // 寻找matrix[i][j]是否等于target
    private boolean findNumberRecursive(int[][] matrix, int rowLength, int colLength,
                                        int i, int j, int target){

        if (i >= rowLength || j >= colLength) {
            return false;
        }

        if (matrix[i][j] == target){
            return true;

        } else if (matrix[i][j] > target) {
            return false;

        } else {
            return findNumberRecursive(matrix, rowLength, colLength, i + 1, j, target)
                    || findNumberRecursive(matrix, rowLength, colLength, i, j + 1, target);
        }
    }




    /**
     * （迭代方式）
     * NOT AC !
     * 执行结果： 超出时间限制
     */
    public boolean findNumberIn2DArray3(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));

        // 寻找matrix[i][j]是否等于target
        while (!queue.isEmpty()) {

            Point point = queue.poll();
            int i = point.row;
            int j = point.col;

            if (matrix[i][j] == target){
                return true;
            } else if (matrix[i][j] > target) {
                continue;

            } else {
                if (i + 1 < rowLength && j < colLength) {
                    queue.offer(new Point(i+1, j));
                }
                if (i < rowLength && j + 1 < colLength) {
                    queue.offer(new Point(i, j+1));
                }
            }
        }

        return false;
    }

    class Point {
        int row;
        int col;
        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
