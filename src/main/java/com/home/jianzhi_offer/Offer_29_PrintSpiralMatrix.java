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
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * @author Poet
 * @date 2020/5/30
 */
public class Offer_29_PrintSpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[] ret = spiralOrder(matrix);
        System.out.println(Arrays.toString(ret));
    }

    public static int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new int[0];

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
//            direction++;
            direction = (++direction) % 4;
        }

        return ret;
    }


    /**
     * 思路一样（边界收缩！）
     * 更简洁的写法：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/solution/mian-shi-ti-29-shun-shi-zhen-da-yin-ju-zhen-she-di/
     */
    public int[] spiralOrder4MoreClear(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if(l > --r) break;
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if(t > --b) break;
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if(++l > r) break;
        }
        return res;
    }

}
