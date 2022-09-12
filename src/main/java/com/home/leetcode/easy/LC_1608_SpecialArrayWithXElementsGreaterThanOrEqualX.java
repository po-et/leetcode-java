package com.home.leetcode.easy;

import java.util.Arrays;

/**
 * 1608. Special Array With X Elements Greater Than or Equal X  (特殊数组的特征值)
 *
 * You are given an array nums of non-negative integers. nums is considered special if there exists a number x such that there are exactly x numbers in nums that are greater than or equal to x.
 *
 * Notice that x does not have to be an element in nums.
 *
 * Return x if the array is special, otherwise, return -1. It can be proven that if nums is special, the value for x is unique.
 *
 * Example 1:
 * Input: nums = [3,5]
 * Output: 2
 * Explanation: There are 2 values (3 and 5) that are greater than or equal to 2.
 *
 * Example 2:
 * Input: nums = [0,0]
 * Output: -1
 * Explanation: No numbers fit the criteria for x.
 * If x = 0, there should be 0 numbers >= x, but there are 2.
 * If x = 1, there should be 1 number >= x, but there are 0.
 * If x = 2, there should be 2 numbers >= x, but there are 0.
 * x cannot be greater since there are only 2 numbers in nums.
 *
 * Example 3:
 * Input: nums = [0,4,3,0,4]
 * Output: 3
 * Explanation: There are 3 values that are greater than or equal to 3.
 *
 * @see <a href="https://leetcode.cn/problems/special-array-with-x-elements-greater-than-or-equal-x/" />
 * @author Poet
 * @date 2022/9/12
 */
public class LC_1608_SpecialArrayWithXElementsGreaterThanOrEqualX {

    /**
     * 方法一：降序排序 + 一次遍历
     *
     * time:  O(nlogn) 其中 n 是数组 nums 的长度
     * space: O(logn)  即为排序需要的栈空间
     */
    public int specialArray(Integer[] nums) {
        int n = nums.length;
//        Arrays.sort(nums, Collections.reverseOrder());
        Arrays.sort(nums);
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] >= i && (i == n || nums[i] < i)) {
                return i;
            }
        }
        return -1;
    }
}
