package com.home.leetcode.medium;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 *
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * @see <a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array" />
 * Created by Poet on 2019-01-15.
 */
public class LC_034_FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * time: O(logn)    看到O(logn)就应该想到二分法
     * space: O(1)
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};

        int start = findFirst(nums, target);
        if (start == -1)
            return new int[]{-1, -1};

        int end = findLast(nums, target);
        return new int[]{start, end};
    }

    private int findFirst(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }

    private int findLast(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[end] == target) return end;
        if (nums[start] == target) return start;
        return -1;
    }

}
