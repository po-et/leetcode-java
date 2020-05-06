package com.home.leetcode.medium;

/**
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/" />
 * @author Poet
 * @date 2020/5/6
 */
public class RemoveDuplicatesFromSortedArray_II_80 {

    public int removeDuplicates(int[] nums) {
        // nums[0..k]表示所有不重复2次的数
        int k = 0;
        // 重复的次数
        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k]) {
                k++;
                nums[k] = nums[i];
                count = 0;

            } else {    // nums[i] == nums[k]
                if (count < 1 ) {
                    k++;
                    nums[k] = nums[i];
                    count ++;
                }
            }
        }
        return k + 1;
    }
}
