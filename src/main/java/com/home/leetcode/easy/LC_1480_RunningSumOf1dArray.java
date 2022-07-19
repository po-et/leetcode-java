package com.home.leetcode.easy;

/**
 * 1480. Running Sum of 1d Array (一维数组的动态和)
 *
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 *
 * Return the running sum of nums.
 *
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [1,3,6,10]
 * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 *
 * Example 2:
 * Input: nums = [1,1,1,1,1]
 * Output: [1,2,3,4,5]
 * Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
 *
 * Example 3:
 * Input: nums = [3,1,2,10,1]
 * Output: [3,4,6,16,17]
 *
 * @see <a href="https://leetcode.cn/problems/running-sum-of-1d-array/" />
 * @author Poet
 * @date 2022/7/19
 */
public class LC_1480_RunningSumOf1dArray {

    /**
     * 方法一：开辟新数组
     *
     * time:  O(n)
     * space: O(n)
     */
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = nums[0];

        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] + nums[i];
        }
        return res;
    }

    /**
     * 方法二：原地修改
     *
     * time:  O(n)
     * space: O(1)
     */
    public int[] runningSum_space_o1(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
