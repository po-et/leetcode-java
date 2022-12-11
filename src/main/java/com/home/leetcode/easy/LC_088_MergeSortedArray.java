package com.home.leetcode.easy;

/**
 * 88. Merge Sorted Array （合并两个有序数组）
 *
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 * Example 1:
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 *
 * Example 2:
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 *
 * Example 3:
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 *
 * @see <a href="https://leetcode.cn/problems/merge-sorted-array" />
 * @author Poet
 * @date 2022/5/12
 */
public class LC_088_MergeSortedArray {

    /**
     * 方法二：双指针
     *
     * time:  O(m+n)
     * space: O(m+n)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int index = 0;

        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                res[index++] = nums1[i];
                i++;
            } else {    // nums1[i] > nums2[j]
                res[index++] = nums2[j];
                j++;
            }
        }
        while (i < m) {
            res[index++] = nums1[i];
            i++;
        }
        while (j < n) {
            res[index++] = nums2[j];
            j++;
        }

        for (int k = 0; k < res.length; k++) {
            nums1[k] = res[k];
        }
    }

    /**
     * 从后往前的原地归并
     */
    public static void merge_1(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1])
                nums1[index--] = nums1[--m];
            else
                nums1[index--] = nums2[--n];
        }

        while (m > 0) {
            nums1[index--] = nums1[--m];
        }
        while (n > 0) {
            nums1[index--] = nums2[--n];
        }
    }


    /**
     * 开辟O(m)空间
     */
    public static void merge_2(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m];
        for (int i = 0; i < m; i++)
            arr[i] = nums1[i];

        int i = 0, j = 0;
        int index = 0;
        while (i < m && j < n) {
            if(arr[i] <= nums2[j])
                nums1[index++] = arr[i++];
            else
                nums1[index++] = nums2[j++];
        }

        while (i < m) {
            nums1[index++] = arr[i++];
        }
        while (j < n) {
            nums1[index++] = nums2[j++];
        }
    }
}
