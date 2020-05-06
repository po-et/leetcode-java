package com.home.leetcode.easy;


/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/" />
 * @author Poet
 * @date 2020/5/6
 */
public class RemoveDuplicatesFromSortedArray_26 {

    public int removeDuplicates(int[] nums) {
        // nums[0..k]表示所有不重复的数
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[k]) {
                k++;
                nums[k] = nums[i];
            }
        }
        // 返回的是length，所以需要+1
        return k + 1;
    }

}
