package com.home.leetcode.easy;

/**
 * 1037. Valid Boomerang
 *
 * Given an array points where points[i] = [xi, yi] represents a point on the X-Y plane, return true if these points are a boomerang.
 *
 * A boomerang is a set of three points that are all distinct and not in a straight line.
 *
 * Example 1:
 * Input: points = [[1,1],[2,3],[3,2]]
 * Output: true
 *
 * Example 2:
 * Input: points = [[1,1],[2,2],[3,3]]
 * Output: false
 *
 * @see <a href="https://leetcode.cn/problems/valid-boomerang/" />
 * @author Poet
 * @date 2022/6/8
 */
public class LC_1037_ValidBoomerang {

    /**
     * 方法一：向量叉乘
     *
     * 此题是经典的三点共线问题，若三点共线，则任意组成的两个向量叉乘为0
     *
     * 官方题解：https://leetcode.cn/problems/valid-boomerang/solution/you-xiao-de-hui-xuan-biao-by-leetcode-so-yqby/
     *
     * time:  O(1)
     * space: O(1)
     */
    public boolean isBoomerang(int[][] points) {
        int[] v1 = {points[1][0] - points[0][0], points[1][1] - points[0][1]};
        int[] v2 = {points[2][0] - points[0][0], points[2][1] - points[0][1]};
        return v1[0] * v2[1] - v1[1] * v2[0] != 0;
    }

}
