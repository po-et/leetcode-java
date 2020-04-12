package com.home.leetcode.medium;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 *
 * @url https://leetcode.com/problems/minimum-size-subarray-sum/
 * @author Poet
 * @date 2020/4/12
 */
public class MinimumSizeSubarraySum_209 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println(minSubArrayLen(s, nums));
    }

    /**
     * time complexity: O(n)
     * space complexity: O(1)
     */
    public static int minSubArrayLen(int s, int[] nums) {
        // nums[l...r]为滑动窗口
        int l = 0, r = -1;
        int sum = 0;
        int res = nums.length +1;
        while (l < nums.length) {
            if(r+1 < nums.length && sum < s) {
                r++;
                sum += nums[r];
            } else {
                sum -= nums[l];
                l++;
            }

            if (sum >= s) {
                res = Math.min(res, r-l+1);
            }
        }

        if(res == nums.length + 1)
            return 0;

        return res;
    }
}
