package com.home.leetcode.easy;

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * @see <a href="https://leetcode.com/problems/remove-element/" />
 * @author Poet
 * @date 2020/5/6
 */
public class RemoveElement_27 {

    public int removeElement(int[] nums, int val) {
        // nums[0..k)表示不是val的数
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if(k != i)
                    nums[k++] = nums[i];
                else
                    k++;
            }
        }
        return k;
    }
}
