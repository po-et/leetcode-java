package com.home.leetcode.medium;

import java.util.Arrays;

/**
 * 593. Valid Square （有效的正方形）
 *
 * Given the coordinates of four points in 2D space p1, p2, p3 and p4, return true if the four points construct a square.
 *
 * The coordinate of a point pi is represented as [xi, yi]. The input is not given in any order.
 *
 * A valid square has four equal sides with positive length and four equal angles (90-degree angles).
 *
 * Example 1:
 * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * Output: true
 *
 * Example 2:
 * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
 * Output: false
 *
 * Example 3:
 * Input: p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
 * Output: true
 *
 * @see <a href="https://leetcode.cn/problems/valid-square/" />
 * @author Poet
 * @date 2022/7/29
 */
public class LC_593_ValidSquare {

    /**
     * 求出6条边，四条边长和两条对角线。
     *
     * 边长相等的只有正方形和菱形，对角线又相等的只有正方形。所以排序判断边长以及对角线是否相等即可
     */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (p1[0] == p2[0] && p1[1] == p2[1]) {
            return false;
        }

        long[] l = new long[6];
        l[0] = len(p1, p2);
        l[1] = len(p1, p3);
        l[2] = len(p1, p4);
        l[3] = len(p2, p3);
        l[4] = len(p2, p4);
        l[5] = len(p3, p4);

        Arrays.sort(l);

        return l[0] == l[1] && l[0] == l[2] && l[0] == l[3] && l[4] == l[5];
    }

    private long len(int[] x, int[] y) {
        return (long) (x[0] - y[0]) * (x[0] - y[0]) + (long) (x[1] - y[1]) * (x[1] - y[1]);
    }
}
