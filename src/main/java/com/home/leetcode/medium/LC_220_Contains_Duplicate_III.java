package com.home.leetcode.medium;

import java.util.TreeSet;

/**
 * 220. Contains Duplicate III
 *
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute
 * difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 *
 * @see <a href = "https://leetcode.cn/problems/contains-duplicate-iii/" />
 * @author Poet
 * @date 2020/4/22
 */
public class LC_220_Contains_Duplicate_III {

    public static void main(String[] args) {
        LC_220_Contains_Duplicate_III solution = new LC_220_Contains_Duplicate_III();
        int[] num = new int[]{1, 2, 3, 1};
        System.out.println(solution.containsNearbyAlmostDuplicate(num, 3, 0));
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

        // 用long型防止整形溢出
        TreeSet<Long> record = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long floor = record.floor((long) nums[i]);
            Long ceil = record.ceiling((long) nums[i]);
            if (floor != null && nums[i] - floor <= t
                    || ceil != null && ceil - nums[i] <= t) {
                return true;
            }
            if (i >= k) {
                record.remove((long) nums[i - k]);
            }
            record.add((long) nums[i]);
        }
        return false;
    }

}
