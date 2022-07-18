package com.home.leetcode.medium;

/**
 * 11. Container With Most Water (盛最多水的容器)
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Example:
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 * @see <a href="https://leetcode.cn/problems/container-with-most-water/" />
 * @author Poet
 * @date 2019/1/10
 */
public class LC_011_ContainerWithMostWater {

    /**
     * 方法一：双指针
     *
     * time:  O(n)
     * space: O(1)
     */
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;

        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            res = Math.max(res, area);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }

}
