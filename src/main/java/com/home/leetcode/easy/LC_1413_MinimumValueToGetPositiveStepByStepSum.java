package com.home.leetcode.easy;

/**
 * 1413. Minimum Value to Get Positive Step by Step Sum （逐步求和得到正数的最小值）
 *
 * Given an array of integers nums, you start with an initial positive value startValue.
 *
 * In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).
 *
 * Return the minimum positive value of startValue such that the step by step sum is never less than 1.
 *
 *
 * Example 1:
 * Input: nums = [-3,2,-3,4,2]
 * Output: 5
 * Explanation: If you choose startValue = 4, in the third iteration your step by step sum is less than 1.
 * step by step sum
 * startValue = 4 | startValue = 5 | nums
 *   (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
 *   (1 +2 ) = 3  | (2 +2 ) = 4    |   2
 *   (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
 *   (0 +4 ) = 4  | (1 +4 ) = 5    |   4
 *   (4 +2 ) = 6  | (5 +2 ) = 7    |   2
 *
 * Example 2:
 * Input: nums = [1,2]
 * Output: 1
 * Explanation: Minimum start value should be positive.
 *
 * Example 3:
 * Input: nums = [1,-2,-3]
 * Output: 5
 *
 * @see <a href="https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum/" />
 * @author Poet
 * @date 2022/8/9
 */
public class LC_1413_MinimumValueToGetPositiveStepByStepSum {

    /**
     * 方法一：贪心
     *
     * 思路：要保证所有的累加和 accSum 满足 accSum+startValue≥1，只需保证累加和的最小值 accSumMin 满足 accSumMin+startValue≥1，
     *      那么 startValue 的最小值即可取 −accSumMin + 1
     */
    public int minStartValue(int[] nums) {
        int accSum = 0;
        int accSumMin = 0;

        for (int num : nums) {
            accSum += num;
            accSumMin = Math.min(accSum, accSumMin);
        }

        return -accSumMin + 1;
    }
}
