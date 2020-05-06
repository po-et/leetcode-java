package com.home.leetcode.easy;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 * @see <a href="https://leetcode.com/problems/move-zeroes/" />
 * @author Poet
 * @date 2020/5/6
 */
public class MoveZeroes_283 {

    public void moveZeroes(int[] nums) {

        // 【循环不变量】 nums[0..k)表示所有非0的数
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if(k != i) {
                    swap(nums, k, i);
                }
                k++;
            }
        }
    }

    private void swap(int[] nums, int k, int i) {
        int tmp = nums[k];
        nums[k] = nums[i];
        nums[i] = tmp;
    }
}
