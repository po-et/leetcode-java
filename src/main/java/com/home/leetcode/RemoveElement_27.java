package com.home.leetcode;

import java.util.Arrays;

/**
 * 27. Remove Element
 *  （类似26，80题）
 *
 *  删除数组中的指定元素，不能增加新的空间
 * Created by Poet on 2019-01-13.
 */
public class RemoveElement_27 {

    /**
     * 得到新数组长度
     *
     * time: O(n)
     * space: O(1)
     */
    public static int removeElement(int[] nums, int val) {
        if(nums==null || nums.length==0) return 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) count++;
        }
        return count;
    }

    /**
     * 方法： two pointer
     */
    public static int[] removeElementArray(int[] nums, int val) {
        if(nums==null || nums.length==0) return nums;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count++] = nums[i];
            }
        }
        return Arrays.copyOf(nums, count);
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 5, 5, 6};
        System.out.println("length: " + nums.length);

        System.out.println(removeElement(nums,2));

        int[] result = removeElementArray(nums,2);
        System.out.println(Arrays.toString(result));
    }


}
