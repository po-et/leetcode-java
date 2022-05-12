package com.home.leetcode.easy;

/**
 * 88. 合并两个有序数组
 *
 * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * @see <a href="https://leetcode.cn/problems/merge-sorted-array" />
 *
 * @author Poet
 * @date 2022/5/12
 */
public class LC_088_MergeSortedArray {

    /**
     * 方法二：双指针
     * time: O(m+n)
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
            } else { // nums1[i] > nums2[j]
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
}
