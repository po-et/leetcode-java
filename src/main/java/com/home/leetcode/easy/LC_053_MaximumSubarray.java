package com.home.leetcode.easy;

/**
 * 53. Maximum Subarray （最大子序和）
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 *
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 *
 * Example 3:
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 *
 * @see <a href="https://leetcode.cn/problems/maximum-subarray/" />
 * @author Poet
 * @date 2022/6/11
 */
public class LC_053_MaximumSubarray {

    /**
     * 方法一：动态规划
     *
     * 状态定义：f(i)代表以第 i 个数结尾的「连续子数组的最大和」
     *           max {f(i)}
     *           0≤i≤n−1
     *
     * 状态转移方程：f(i) = max{ f(i−1)+nums[i], nums[i] }
     *
     * time:  O(n)
     * space: O(n)
     *
     * 好理解的题解：https://leetcode.cn/problems/maximum-subarray/solution/dong-tai-gui-hua-fen-zhi-fa-python-dai-ma-java-dai/
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        // dp[i]表示：以nums[i]为结尾的连续子数组的最大和
        int[] dp = new int[len];
        // 初始化
        dp[0] = nums[0];

        // 开始递推
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        // 也可以在上面遍历的同时求出 res 的最大值，这里我们为了语义清晰分开写，大家可以自行选择
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 方法一的空间优化代码，space：O(1)
     */
    public int maxSubArray_space_o1(int[] nums) {
        int pre = 0;
        int res = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            res = Math.max(res, pre);
        }
        return res;
    }

}
