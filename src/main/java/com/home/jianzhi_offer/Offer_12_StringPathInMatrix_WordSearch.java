package com.home.jianzhi_offer;

import com.home.leetcode.medium.LC_079_WordSearch;

/**
 * 面试题12. 矩阵中的路径
 *
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用下划线标出）。
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *  A B T G
 *  C F C S
 *  J D E H
 *
 * @see <a href="https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/" />
 * @author Poet
 * @date 2020/5/16
 */
public class Offer_12_StringPathInMatrix_WordSearch {

    /**
     * 回溯法
     *
     * 直接看主站 {@link LC_079_WordSearch} liuyubo讲解过，更清晰
     */


    // Solution: <a href="https://www.cnblogs.com/yongh/p/9655745.html" />
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null) {
            return false;
        }

        boolean[] isVisited = new boolean[rows * cols];
        for (boolean v : isVisited) {
            v = false;
        }

        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, isVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col,
                                char[] str, int pathLength,
                                boolean[] isVisited) {
        if (row < 0 || col < 0 || row >= rows || col >= cols || isVisited[row * cols + col]
                || str[pathLength] != matrix[row * cols + col]) {
            return false;
        }

        if (pathLength == str.length - 1) {
            return true;
        }

        isVisited[row * cols + col] = true;

        boolean hasPath = hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength + 1, isVisited)
                || hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength + 1, isVisited)
                || hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength + 1, isVisited)
                || hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength + 1, isVisited);

        if (!hasPath) {
            isVisited[row * cols + col] = false;
        }
        return hasPath;
    }

}
