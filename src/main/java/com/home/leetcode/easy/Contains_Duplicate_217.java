package com.home.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * @see <a href = "https://leetcode.com/problems/contains-duplicate/" />
 * @author Poet
 * @date 2020/4/21
 */
public class Contains_Duplicate_217 {

    public static void main(String[] args) {
        Contains_Duplicate_217 solution = new Contains_Duplicate_217();

        int [] nums = {1,2,3,1};
        System.out.println(solution.containsDuplicate(nums));
    }

    /**
     * time: O(n)
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> record = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.contains(nums[i])) {
                return true;
            }
            record.add(nums[i]);
        }
        return false;
    }

}
