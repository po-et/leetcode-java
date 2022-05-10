package com.home.leetcode.easy;

import java.util.Arrays;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/" >...</a>
 * @author Poet
 * @date 2020/5/6
 */
public class LC_026_RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
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


    /**
     * time: O(n)
     * space: O(1)
     */
    public static int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        // 循环不变量：nums[0, j)没有重复的元素
        // j指向了下一个要赋值的元素
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    /**
     * time: O(n)
     * space: O(1)
     */
    public static int removeDuplicates3(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        // 循环不变量：nums[0, j]没有重复的元素
        // j指向已赋值的最后一个元素
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[j]){
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
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
