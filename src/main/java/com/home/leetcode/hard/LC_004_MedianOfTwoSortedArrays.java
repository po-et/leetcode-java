package com.home.leetcode.hard;

/**
 * 4. Median of Two Sorted Arrays（寻找两个有序数组的中位数）
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 *
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 * @see <a href="https://leetcode.cn/problems/median-of-two-sorted-arrays/" />
 * @author Poet
 * @date 2022/7/18
 */
public class LC_004_MedianOfTwoSortedArrays {

    /**
     * 方法一：使用归并的方式，合并两个有序数组，得到一个大的有序数组。大的有序数组的中间位置的元素，即为中位数。
     *
     * time:  O(m+n)
     * space: O(m+n)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergeArray = merge(nums1, nums2);
        int n = mergeArray.length;

        if ((n & 1) == 1) {   // odd
            return mergeArray[n / 2];
        } else {
            return (mergeArray[n / 2 - 1] + mergeArray[n / 2]) / 2.0;
        }
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int l = 0, r = 0;
        int n = nums1.length, m = nums2.length;
        int[] res = new int[m + n];
        int index = 0;

        while (l < n && r < m) {
            if (nums1[l] <= nums2[r]) {
                res[index++] = nums1[l++];
            } else {
                res[index++] = nums2[r++];
            }
        }
        while (l < n) {
            res[index++] = nums1[l++];
        }
        while (r < m) {
            res[index++] = nums2[r++];
        }
        return res;
    }

}
