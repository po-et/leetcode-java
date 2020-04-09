package com.home.leetcode;

import com.home.leetcode.utils.ArrayUtils;

import java.util.Arrays;

/**
 * we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Example:
 *   Input:  [2,0,2,1,1,0]
 *   Output: [0,0,1,1,2,2]
 *
 * @url https://leetcode.com/problems/sort-colors/
 * @author Poet
 * @date 2020/4/9
 */
public class SortColors_75 {

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};

//        sortColors(nums);
//        System.out.println(Arrays.toString(nums));

        sortColorsViaThreeQuickWays(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * time: O(n)
     * space: O(k) k是元素的取值范围（也可以说是O(1)）
     */
    public static void sortColors(int[] nums) {
        int[] countArray = new int[3];

        for (int i = 0; i < nums.length; i++) {
            // 考虑越界情况
            assert (nums[i] >= 0 && nums[i] <= 2) ;
            countArray[nums[i]]++;
        }

        int index = 0;
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                nums[index++] = i;
            }
        }
    }

    /**
     * 使用三路快排partition的思路
     * time: O(n)
     * space: O(1)
     */
    public static void sortColorsViaThreeQuickWays(int[] nums) {
        int lt = -1;
        int gt = nums.length;

        // 循环不变量 [0...lt]==0, [lt+1...i-1]==1, [gt...length-1]==2
        for (int i = 0; i < gt; ) {
            if (nums[i] == 0) {
                lt++;
                ArrayUtils.swap(nums, lt, i);
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else { //nums[i] == 2
                gt--;
                ArrayUtils.swap(nums, i, gt);
            }
        }
    }


}
