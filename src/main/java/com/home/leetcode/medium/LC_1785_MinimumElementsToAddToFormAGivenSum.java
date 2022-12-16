package com.home.leetcode.medium;

/**
 * 1785. Minimum Elements to Add to Form a Given Sum (构成特定和需要添加的最少元素)
 *
 * You are given an integer array nums and two integers limit and goal. The array nums has an interesting property that abs(nums[i]) <= limit.
 *
 * Return the minimum number of elements you need to add to make the sum of the array equal to goal. The array must maintain its property that abs(nums[i]) <= limit.
 *
 * Note that abs(x) equals x if x >= 0, and -x otherwise.
 *
 * Example 1:
 * Input: nums = [1,-1,1], limit = 3, goal = -4
 * Output: 2
 * Explanation: You can add -2 and -3, then the sum of the array will be 1 - 1 + 1 - 2 - 3 = -4.
 *
 * Example 2:
 * Input: nums = [1,-10,9,1], limit = 100, goal = 0
 * Output: 1
 *
 * @see <a href="https://leetcode.cn/problems/minimum-elements-to-add-to-form-a-given-sum/" />
 * @author Poet
 * @date 2022/12/16
 */
public class LC_1785_MinimumElementsToAddToFormAGivenSum {

    /**
     * 方法一：上取整
     *
     * time:  O(n)
     * space: O(1)
     */
    public int minElements(int[] nums, int limit, int goal) {
//        long sum = Arrays.stream(nums).sum(); // error，有越界
        long sum = 0;
        for (int x : nums) {
            sum += x;
        }
        long diff = Math.abs(sum - goal);
        return (int) ((diff + limit - 1) / limit);
    }

}
