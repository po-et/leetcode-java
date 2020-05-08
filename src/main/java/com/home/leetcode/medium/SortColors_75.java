package com.home.leetcode.medium;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * @see <a href="https://leetcode.com/problems/sort-colors/submissions/" />
 * @author Poet
 * @date 2020/5/9
 */
public class SortColors_75 {

    /**
     * 基于快排partition的思想
     */
    public void sortColors(int[] nums) {
        // 明确参数语义
        // nums[0..zero] == 0, nums[zero+1..i) == 1, nums[two...length] == 2
        int zero = -1;
        int two = nums.length;
        int i = 0;

        while (i < two) {
            if (nums[i] == 0) {
                zero++;
                swap(nums, i, zero);
                i++;
            } else if(nums[i] == 2) {
                two --;
                swap(nums, i, two);
            } else {
                assert nums[i] == 1;
                i++;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    /**
     * 计数排序
     */
    public void sortColors2(int[] nums) {
        int[] stat = {0, 0, 0};
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0)
                stat[0]++;
            else if(nums[i] == 1)
                stat[1]++;
            else {
                assert nums[i] == 2;
                stat[2]++;
            }
        }

        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < stat[i]; j++) {
                nums[index++] = i;
            }
        }
    }


}
