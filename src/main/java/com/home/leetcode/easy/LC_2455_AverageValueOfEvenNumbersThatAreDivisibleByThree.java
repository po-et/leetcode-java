package com.home.leetcode.easy;

/**
 * 2455. Average Value of Even Numbers That Are Divisible by Three
 *
 * Given an integer array nums of positive integers, return the average value of all even integers that are divisible by 3.
 *
 * Note that the average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
 *
 * Example 1:
 * Input: nums = [1,3,6,10,12,15]
 * Output: 9
 * Explanation: 6 and 12 are even numbers that are divisible by 3. (6 + 12) / 2 = 9.
 *
 * Example 2:
 * Input: nums = [1,2,4,7,10]
 * Output: 0
 * Explanation: There is no single number that satisfies the requirement, so return 0.
 *
 * @see <a href="https://leetcode.cn/problems/average-value-of-even-numbers-that-are-divisible-by-three/" />
 * @author Poet
 * @date 2023/5/29
 */
public class LC_2455_AverageValueOfEvenNumbersThatAreDivisibleByThree {

    /**
     * 方法一：遍历
     *
     * time:  O(N)
     * space: O(1)
     */
    public int averageValue(int[] nums) {
        long sum = 0;
        int count = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                sum += num;
                count++;
            }
        }
        return count > 0 ? Math.toIntExact(sum / count) : 0;
    }

}
