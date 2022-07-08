package com.home.leetcode.hard;

import java.util.Arrays;

/**
 * 719. Find K-th Smallest Pair Distance （找出第 K 小的数对距离）
 *
 * The distance of a pair of integers a and b is defined as the absolute difference between a and b.
 *
 * Given an integer array nums and an integer k, return the kth smallest distance among all the pairs nums[i] and nums[j] where 0 <= i < j < nums.length.
 *
 * Example 1:
 * Input: nums = [1,3,1], k = 1
 * Output: 0
 * Explanation: Here are all the pairs:
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * Then the 1st smallest distance pair is (1,1), and its distance is 0.
 *
 * Example 2:
 * Input: nums = [1,1,1], k = 2
 * Output: 0
 *
 * Example 3:
 * Input: nums = [1,6,1], k = 3
 * Output: 5
 *
 * @see <a href="https://leetcode.cn/problems/find-k-th-smallest-pair-distance" />
 * @author poet
 * @date 2022/6/15
 */
public class LC_719_FindKthSmallestPairDistance {

    /**
     * 方法一：排序 + 二分查找
     */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, left = 0, right = nums[n - 1] - nums[0];

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                int i = binarySearch(nums, j, nums[j] - mid);
                cnt += j - i;
            }
            if (cnt >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int binarySearch(int[] nums, int end, int target) {
        int left = 0, right = end;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
