package com.home.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 219. Contains Duplicate II
 *
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 *
 * @see <a href = "https://leetcode.cn/problems/contains-duplicate-ii/" />
 * @author Poet
 * @date 2020/4/21
 */
public class LC_219_Contains_Duplicate_II {

    public static void main(String[] args) {
        LC_219_Contains_Duplicate_II solution = new LC_219_Contains_Duplicate_II();

        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(solution.containsNearbyDuplicate(nums, k));

        int[] nums2 = {1, 2, 3, 1, 2, 3};
        int k2 = 2;
        System.out.println(solution.containsNearbyDuplicate(nums2, k2));
    }

    /**
     * 固定长度的滑动窗口
     *
     * time: O(n)
     * space: O(k)
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> record = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (record.contains(nums[i])) {
                return true;
            }

            record.add(nums[i]);

            if (record.size() == k + 1) {   // 注意边界：不超过k，实际长度为k+1
                record.remove(nums[i - k]);
            }
        }
        return false;
    }

    /**
     * 滑动窗口
     *
     * time: O(n)
     * space: O(k)
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (nums == null) {
            throw new IllegalArgumentException("nums is not valid.");
        }

        Set<Integer> record = new HashSet<>();
        int l = 0, r = 0;
        while (r < nums.length) {
            if (r - l > k) {
                record.remove(nums[l]);
                l++;
            }

            if (record.contains(nums[r])) {
                return true;
            }
            record.add(nums[r]);
            r++;
        }
        return false;
    }
}
