package com.home.leetcode;

import java.util.Arrays;

/**
 * @author poet
 * @date 2019/11/3
 */
public class MoveZeroes_283 {

    public static void moveZeroes(int[] nums) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                if(i != index)
                    swap(nums, i, index++);
                else
                    index++;
        }
    }

    private static void swap(int arr[], int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

    public static void moveZeroes2(int[] nums) {

        int[] data = new int[nums.length];

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                data[index++] = nums[i];
            }
        }

        while (index < nums.length) {
            data[index++] = 0;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = data[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 0, 3, 0, 4, 0};
        System.out.println(nums.length);
        System.out.println(Arrays.toString(nums));

        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
