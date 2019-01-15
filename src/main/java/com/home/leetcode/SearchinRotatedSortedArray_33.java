package com.home.leetcode;

import java.util.Arrays;

/**
 * 33. Serach in Rotated Sorted Array
 * (i.e. 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2)
 * Created by Poet on 2019-01-15.
 */
public class SearchinRotatedSortedArray_33 {
    /**
     * 4 5 6 7 0 1 2
     * 4 5 6 0 1 2 3
     * <p>
     * 考的是binary search，时间复杂度如果是O(n)这样循环遍历则没有意义
     * time: O(logn)
     * space: O(1)
     */

    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {            //start < end 会死循环
            int mid = (end - start) / 2 + start;
            if(nums[mid] == mid) return mid;
            if (nums[start] < nums[mid]) {  //前面是升序
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else start = mid;
            } else {                        //后面是升序
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else end = mid;
            }
        }
        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(Arrays.toString(nums));
        System.out.println(search(nums, 2));
    }

}
