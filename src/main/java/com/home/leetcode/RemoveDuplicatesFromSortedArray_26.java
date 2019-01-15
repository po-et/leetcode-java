package com.home.leetcode;

import java.util.Arrays;

/**
 * Created by Poet on 2019-01-13.
 */
public class RemoveDuplicatesFromSortedArray_26 {

    /**
     * 去除sorted array重复元素后的长度
     *
     * time: O(n)
     * space: O(1)
     */
    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                count++;
            }
        }
        return count;
    }


    /**
     * 去除sorted array重复元素
     */
//    public static int removeDuplicatesArray(int[] nums) {
//        if(nums == null || nums.length == 0) return 0;
//        int count = 1;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] != nums[i - 1]) {
//                nums[count++] = nums[i];
//            }
//        }
////        System.arraycopy(nums, 0, nums, 0, count);
//        return count;
//    }

    /**
     * 得到去除sorted array重复元素后的array
     *  方法： two pointer
     * by myself
     */
    public static int[] removeDuplicatesArray2(int[] nums) {
        int[] result = new int[nums.length];
        if(nums == null || nums.length == 0) return result;
        int count = 1;
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                result[count] = nums[i];
                count++;
            }
        }
        System.out.println("length: " + result.length + ", result:" + Arrays.toString(result));
        result = Arrays.copyOf(result, count);
        System.out.println("length: " + result.length + ", result:" + Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 5, 5, 6};
        System.out.println("length: " + nums.length);

        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

//        System.out.println(removeDuplicatesArray(nums));
//        System.out.println(Arrays.toString(nums));

        removeDuplicatesArray2(nums);
    }
}
