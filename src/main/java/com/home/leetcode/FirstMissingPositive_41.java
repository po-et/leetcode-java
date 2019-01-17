package com.home.leetcode;

/**
 * 41. First Missing Positive

 Given an unsorted integer array, find the first missing positive integer.

 For example,
     Given [1,2,0] return 3,
     and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.

 * Created by Poet on 2019-01-17.
 */
public class FirstMissingPositive_41 {

    /**
     * 桶排序的思想
     * （先将数字都放到正确的地方）
     *  重点理解： nums[nums[i] - 1] != nums[i]
     *
     * time: O(n)
     * space: O(1)
     */
    public int firstMissingPositive(int[] nums) {
        if(nums ==null || nums.length==0) return 1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

}
