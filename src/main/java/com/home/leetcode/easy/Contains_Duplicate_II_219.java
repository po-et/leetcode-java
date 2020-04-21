package com.home.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *
 * @see <a href = "https://leetcode.com/problems/contains-duplicate-ii/" />
 * @author Poet
 * @date 2020/4/21
 */
public class Contains_Duplicate_II_219 {

    public static void main(String[] args) {
        Contains_Duplicate_II_219 solution = new Contains_Duplicate_II_219();

        int [] nums = {1,2,3,1};
        int k = 3;
        System.out.println(solution.containsNearbyDuplicate(nums, k));

        int [] nums2 = {1,2,3,1,2,3};
        int k2 = 2;
        System.out.println(solution.containsNearbyDuplicate(nums, k2));
    }

    /**
     * time: O(n)
     * space: O(k)
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
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

    /**
     * time: O(n)
     * space: O(k)
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> record = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.contains(nums[i])) {
                return true;
            }
            record.add(nums[i]);
            if (record.size() == k + 1) {
                record.remove(nums[i - k]);
            }
        }
        return false;
    }
}
