package com.home.leetcode.easy;

import java.util.Arrays;

/**
 * 283. Move Zeroes
 *
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
 * @see <a href="https://leetcode.cn/problems/move-zeroes/" />
 * @author Poet
 * @date 2020/5/6
 */
public class LC_283_MoveZeroes {

    /**
     * swap （Better！）
     * time: O(n)
     * space: O(1)
     */
    public void moveZeroes(int[] nums) {
        // 【循环不变量】 nums[0..k)表示所有非0的数
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (k != i) {
                    swap(nums, k, i);
                }
                k++;
            }
        }
    }

    /**
     * 赋值
     * time: O(n)
     * space: O(1)
     */
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        // 循环不变量：nums[0, j)不包含0元素
        // j指向第一个0的位置
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    private static void swap(int arr[], int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }


    public static void main(String[] args) {
        LC_283_MoveZeroes solution = new LC_283_MoveZeroes();

        int[] nums = {0, 1, 0, 2, 0, 3, 0, 4, 0};
        System.out.println(Arrays.toString(nums));
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
