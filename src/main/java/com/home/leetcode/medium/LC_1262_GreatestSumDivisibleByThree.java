package com.home.leetcode.medium;

/**
 * 1262. Greatest Sum Divisible by Three（可被三整除的最大和）
 *
 * Given an integer array nums, return the maximum possible sum of elements of the array such that it is divisible by three.
 *
 * Example 1:
 * Input: nums = [3,6,5,1,8]
 * Output: 18
 * Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).
 *
 * Example 2:
 * Input: nums = [4]
 * Output: 0
 * Explanation: Since 4 is not divisible by 3, do not pick any number.
 *
 * Example 3:
 * Input: nums = [1,2,3,4,4]
 * Output: 12
 * Explanation: Pick numbers 1, 3, 4 and 4 their sum is 12 (maximum sum divisible by 3).
 *
 * @see <a href="https://leetcode.cn/problems/greatest-sum-divisible-by-three/" />
 * @author Poet
 * @date 2023/6/19
 */
public class LC_1262_GreatestSumDivisibleByThree {

    /**
     * 方法三：动态规划
     */
    public int maxSumDivThree(int[] nums) {
        int[] f = {0, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int num : nums) {
            int[] g = new int[3];
            System.arraycopy(f, 0, g, 0, 3);
            for (int i = 0; i < 3; ++i) {
                g[(i + num % 3) % 3] = Math.max(g[(i + num % 3) % 3], f[i] + num);
            }
            f = g;
        }
        return f[0];
    }

}
