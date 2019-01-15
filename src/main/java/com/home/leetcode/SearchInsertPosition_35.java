package com.home.leetcode;

/**
 * 35. Search Insert Position
 *
 * 一个排序好的数组，如果插入的数其中有直接返回index，没有的话返回插入的位置
 * Created by Poet on 2019-01-15.
 */
public class SearchInsertPosition_35 {

    /**
     * time: O(logn)
     * space: O(1)
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end-start)/2 + start;
            if(nums[mid] == target) return mid;
            if (nums[mid] < target) start  = mid;
            else end = mid;
        }
        if (target <= nums[start]) {
            return start;
        } else if (target <= nums[end]) {
            return end;
        } else {
            return end + 1;
        }
    }
}
