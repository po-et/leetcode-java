package com.home.leetcode;

/**
 * Example:
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 * @url https://leetcode.com/problems/container-with-most-water/
 * Created by Poet on 2019-01-10.
 */
public class ContainerWithMostWater_11 {

    /**
     * time complexity: O(n)
     * space complexity: O(1)
     */
    public int maxArea(int[] height) {
        int res = 0;
        int l   = 0, r = height.length - 1;
        while (l < r) {
            res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }

}
