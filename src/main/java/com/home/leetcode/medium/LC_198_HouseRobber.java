package com.home.leetcode.medium;

/**
 * 198. House Robber（打家劫舍）
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 *
 * @see <a href="https://leetcode.cn/problems/house-robber/" />
 * @author Poet
 * @date 2022/6/1
 */
public class LC_198_HouseRobber {

    /**
     * 【重点】DP的思路
     *
     * 状态的定义：（函数的定义，即要做什么）
     *    定义：考虑偷取[x...n-1]范围里的房子
     *
     * 状态的转移：（函数的转移，即要怎么做）
     *    根据对状态的定义，决定状态的转移：
     *    状态转移方程： f(0) = max{ v(0)+f(2), v(1)+f(3), v(2)+f(4), .... v(n-3)+f(n-1), v(n-2), v(n-1) }
     */

    // memo[i]表示考虑抢劫 nums[i...n) 所能获得的最大收益
    private int[] memo;

    /**
     * 方法一：递归（记忆化搜索）
     */
    public int rob(int[] nums) {
        memo = new int[nums.length];
        return tryRob(nums, 0);
    }

    // 考虑抢劫 nums[index...nums.length) 这个范围的所有房子
    private int tryRob(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }

        if (memo[index] != 0) {
            return memo[index];
        }
        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + tryRob(nums, i + 2));
        }
        memo[index] = res;
        return res;
    }


    /**
     * 方法二：动态规划
     */
    public int rob_DP(int[] nums) {
        int n = nums.length;

        // memo[i]表示考虑抢劫 nums[i...n) 所能获得的最大收益
        int[] memo = new int[n];
        memo[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                memo[i] = Math.max(memo[i], nums[j] + (j + 2 < n ? memo[j + 2] : 0));
            }
        }

        return memo[0];
    }

}
