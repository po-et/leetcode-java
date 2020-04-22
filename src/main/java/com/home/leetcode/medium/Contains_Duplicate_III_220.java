package com.home.leetcode.medium;

import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 *
 * @see <a href = "https://leetcode.com/problems/contains-duplicate-iii/" />
 * @author Poet
 * @date 2020/4/22
 */
public class Contains_Duplicate_III_220 {

    public static void main(String[] args) {
        Contains_Duplicate_III_220 solution = new Contains_Duplicate_III_220();
    }

    /**
     * time: O(nlogn)
     * space: O(k)
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // Deal with corner cases
        if (k <= 0 || nums.length < 2) {
            return false;
        }

        TreeSet<Long> record = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long floor = record.floor( (long) nums[i]);
            Long ceil =  record.ceiling( (long) nums[i]);
            if (floor != null && nums[i] - floor <= t
                    || ceil != null && ceil - nums[i] <= t) {
                return true;
            }
            if (i >= k) {
                record.remove((long)nums[i - k]);
            }
            record.add((long)nums[i]);
        }
        return false;
    }
}
