package com.home.leetcode.jianzhi_offer;

/**
 * 面试题42. 连续子数组的最大和
 *
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 * 示例1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 * @author Poet
 * @date 2020/5/31
 */
public class Offer_42_MaximumSubarray {

    /**
     * [动态规划]
     *
     * 状态定义：设动态规划列表 dp ，dp[i]代表以元素 nums[i]为结尾的连续子数组最大和。
     * 转移方程：...
     * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/solution/mian-shi-ti-42-lian-xu-zi-shu-zu-de-zui-da-he-do-2/
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = nums[i] + dp[i - 1];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 上述简洁写法，空间复杂度从 O(n) -> O(1)
    public int maxSubArray_better(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }


    /**
     * Wrong !!!
     */
    // 对撞指针
    public int maxSubArrayWrong(int[] nums) {
        // 先遍历一遍，求sum
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int res = sum;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[r] <= nums[l]) {
                sum -= nums[r];
                r--;
            } else {
                sum -= nums[l];
                l++;
            }
            res = Math.max(res, sum);
        }
        return res;
    }

}
