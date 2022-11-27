package com.home.leetcode.easy;

/**
 * 1752. Check if Array Is Sorted and Rotated
 *
 * Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.
 *
 * There may be duplicates in the original array.
 *
 * Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.
 *
 * Example 1:
 * Input: nums = [3,4,5,1,2]
 * Output: true
 * Explanation: [1,2,3,4,5] is the original sorted array.
 * You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].
 *
 * Example 2:
 * Input: nums = [2,1,3,4]
 * Output: false
 * Explanation: There is no sorted array once rotated that can make nums.
 *
 * Example 3:
 * Input: nums = [1,2,3]
 * Output: true
 * Explanation: [1,2,3] is the original sorted array.
 * You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
 *
 * @see <a href="https://leetcode.cn/problems/check-if-array-is-sorted-and-rotated/" />
 * @author Poet
 * @date 2022/11/27
 */
public class LC_1752_CheckIfArrayIsSortedAndRotated {

    /**
     * 方法：直接遍历
     *
     * 自己完成 ac
     */
    public boolean check(int[] nums) {
        int rotatedStart = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                rotatedStart = i + 1;
                break;
            }
        }

        if (rotatedStart == nums.length - 1) {
            return nums[rotatedStart] >= nums[0];
        }
        if (rotatedStart < 0) {
            return true;
        }

        for (int i = rotatedStart; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i] || nums[i] > nums[0] || nums[i + 1] > nums[0]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 方法一：直接遍历
     */
    public boolean check_1(int[] nums) {
        int n = nums.length, x = 0;
        for (int i = 1; i < n; ++i) {
            if (nums[i] < nums[i - 1]) {
                x = i;
                break;
            }
        }
        if (x == 0) {
            return true;
        }
        for (int i = x + 1; i < n; ++i) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return nums[0] >= nums[n - 1];
    }

}
