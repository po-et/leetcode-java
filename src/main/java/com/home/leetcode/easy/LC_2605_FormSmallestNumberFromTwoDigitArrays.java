package com.home.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2605. Form Smallest Number From Two Digit Arrays
 *
 * Given two arrays of unique digits nums1 and nums2, return the smallest number that contains at least one digit from each array.
 *
 * Example 1:
 * Input: nums1 = [4,1,3], nums2 = [5,7]
 * Output: 15
 * Explanation: The number 15 contains the digit 1 from nums1 and the digit 5 from nums2. It can be proven that 15 is the smallest number we can have.
 *
 * Example 2:
 * Input: nums1 = [3,5,2,6], nums2 = [3,1,7]
 * Output: 3
 * Explanation: The number 3 contains the digit 3 which exists in both arrays.
 *
 * @see <a href="https://leetcode.cn/problems/form-smallest-number-from-two-digit-arrays/" />
 * @author Poet
 * @date 2023/9/5
 */
public class LC_2605_FormSmallestNumberFromTwoDigitArrays {

    /**
     * 方法：分类讨论
     */
    public int minNumber(int[] nums1, int[] nums2) {
        // 是否有相同的数
        int s = same(nums1, nums2);
        if (s != -1) {
            return s;
        }

        // 无相同的数，取最小
        int x = Arrays.stream(nums1).min().getAsInt();
        int y = Arrays.stream(nums2).min().getAsInt();
        return Math.min(x * 10 + y, y * 10 + x);
    }

    public int same(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums1) {
            s.add(num);
        }

        int x = 10;
        for (int num : nums2) {
            if (s.contains(num)) {
                x = Math.min(x, num);
            }
        }
        return x == 10 ? -1 : x;
    }

}
