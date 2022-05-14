package com.home.leetcode.medium;

/**
 * 209. 长度最小的子数组
 *
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of
 * which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 *
 * @see <a href="https://leetcode.com/problems/minimum-size-subarray-sum/" />
 * @author Poet
 * @date 2020/4/12
 */
public class LC_209_MinimumSizeSubarraySum {

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
        int l = 0, r = -1;  // r = -1 是因为前闭后闭区间，初始不应该包括这个范围
        int sum = 0;
        int res = nums.length + 1;

        while (l < nums.length) {
            if (r + 1 < nums.length && sum < s) {   // 所有用到数组取值的地方，都要考虑是否越界
                r++;
                sum += nums[r];
            } else {
                sum -= nums[l];
                l++;
            }

            if (sum >= s) {
                res = Math.min(res, r - l + 1); // 前闭后闭区间，所以计算长度的时候需要+1
            }
        }

        if (res == nums.length + 1) {
            return 0;
        }
        return res;
    }

}
