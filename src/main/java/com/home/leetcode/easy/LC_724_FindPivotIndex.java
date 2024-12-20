package com.home.leetcode.easy;

import java.util.Arrays;

/**
 * 724. Find Pivot Index
 *
 * Given an array of integers nums, calculate the pivot index of this array.
 *
 * The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
 *
 * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
 *
 * Return the leftmost pivot index. If no such index exists, return -1.
 *
 * Example 1:
 * Input: nums = [1,7,3,6,5,6]
 * Output: 3
 * Explanation:
 * The pivot index is 3.
 * Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
 * Right sum = nums[4] + nums[5] = 5 + 6 = 11
 *
 * Example 2:
 * Input: nums = [1,2,3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 *
 * Example 3:
 * Input: nums = [2,1,-1]
 * Output: 0
 * Explanation:
 * The pivot index is 0.
 * Left sum = 0 (no elements to the left of index 0)
 * Right sum = nums[1] + nums[2] = 1 + -1 = 0
 *
 * @see <a href="https://leetcode.cn/problems/find-pivot-index/" />
 * @author Poet
 * @date 2022/7/19
 */
public class LC_724_FindPivotIndex {

    /**
     * 方法一：前缀和
     *
     * time:  O(n)
     * space: O(1)
     */
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        // 举例：left... nums[i] ...right
        // 1) left + num[i] + right = sum
        // 2) 如果左右相等，则 left = right
        // ----> 2 * left + nums[i] = sum

        int left = 0;   // 空和为0
        for (int i = 0; i < nums.length; i++) {
            if (2 * left + nums[i] == sum) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }
}
