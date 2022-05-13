package com.home.leetcode.medium;

/**
 * 11. 盛最多水的容器
 *
 * Example:
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 * @see <a href = "https://leetcode.cn/problems/container-with-most-water/" />
 * @author Poet
 * @date 2019/1/10
 */
public class LC_011_ContainerWithMostWater {

    /**
     * time complexity: O(n)
     * space complexity: O(1)
     */
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;

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
