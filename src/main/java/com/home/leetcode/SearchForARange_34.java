package com.home.leetcode;

/**
 * 34. search for a range
 * for example:
 *  Given [5,7,7,8,8,10] and targbet value 8,
 *  return [3,4]
 * Created by Poet on 2019-01-15.
 */
public class SearchForARange_34 {

    /**
     * time: O(logn)    看到O(logn)就应该想到二分法
     * space: O(1)
     */
    public int[] searchRange(int[] nums, int target) {
        if(nums ==null || nums.length==0) return new int[]{-1, -1};
        int start = findFirst(nums, target);
        if(start==-1) return new int[]{-1, -1};
        int end = findLast(nums, target);
        return new int[]{start, end};
    }

    private int findFirst(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        return -1;
    }

    private int findLast(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if(nums[end] == target) return end;
        if(nums[start] == target) return start;
        return -1;
    }
}
