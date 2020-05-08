package com.home.leetcode.medium;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 *
 * @see <a href="https://leetcode.com/problems/merge-sorted-array/" />
 * @author Poet
 * @date 2020/5/8
 */
public class MergeSortedArray_85 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

    }

    /**
     * 开辟O(m)空间
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
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
            nums1[index++] = nums1[i++];
        }
        while (j < n) {
            nums1[index++] = nums2[j++];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2,0}, nums2 = {1};
        int n = 1, m =1;
        System.out.println(Arrays.toString(nums1));

        merge2(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
