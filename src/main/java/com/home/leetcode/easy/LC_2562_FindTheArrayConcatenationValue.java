package com.home.leetcode.easy;

/**
 * 2562. Find the Array Concatenation Value (找出数组的串联值)
 *
 * You are given a 0-indexed integer array nums.
 *
 * The concatenation of two numbers is the number formed by concatenating their numerals.
 *
 * For example, the concatenation of 15, 49 is 1549.
 * The concatenation value of nums is initially equal to 0. Perform this operation until nums becomes empty:
 *
 * If there exists more than one number in nums, pick the first element and last element in nums respectively and add the value of their concatenation to the concatenation value of nums, then delete the first and last element from nums.
 * If one element exists, add its value to the concatenation value of nums, then delete it.
 * Return the concatenation value of the nums.
 *
 * @see <a href="https://leetcode.cn/problems/find-the-array-concatenation-value/description/?envType=daily-question&envId=2023-10-12" />
 * @author Poet
 * @date 2023/10/12
 */
public class LC_2562_FindTheArrayConcatenationValue {

    /**
     * 直接模拟
     */
    public long findTheArrayConcVal(int[] nums) {
        long ans = 0;
        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            if (i != j) {
                ans += Integer.parseInt(Integer.toString(nums[i]) + Integer.toString(nums[j]));
            } else {
                ans += nums[i];
            }
        }
        return ans;
    }

}
