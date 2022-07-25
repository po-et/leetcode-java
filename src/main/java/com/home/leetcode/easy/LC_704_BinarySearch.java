package com.home.leetcode.easy;

/**
 * 704. Binary Search (二分查找)
 *
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 *
 * Example 2:
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *
 * @see <a href="https://leetcode.cn/problems/binary-search/" />
 * @author Poet
 * @date 2022/7/25
 */
public class LC_704_BinarySearch {

    /**
     * 方法一：二分查找
     *
     * time:  O(logn)，其中 n 是数组的长度
     * space: O(1)
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
