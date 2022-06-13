package com.home.leetcode.easy;

import java.util.Arrays;

/**
 * 496. Next Greater Element I
 *
 * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
 *
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 *
 * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 *
 * Example 1:
 *  Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 *  Output: [-1,3,-1]
 *  Explanation: The next greater element for each value of nums1 is as follows:
 *  - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 *  - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
 *  - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 *
 * @see <a href="https://leetcode.cn/problems/next-greater-element-i" />
 * @author Poet
 * @date 2022/6/13
 */
public class LC_496_NextGreaterElement_I {

    /**
     * 方法一：暴力解法
     * time:  O(mn)
     * space: O(1)
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] res = new int[m];
        Arrays.fill(res, -1);
        int pivot;

        for (int i = 0; i < m; i++) {
            pivot = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (nums1[i] == nums2[j]) {
                    pivot = j;
                }
                if (j > pivot && nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 方法二：单调栈 + 哈希表
     * time:  O(m+n)
     * space: O(n)
     *
     * 官方题解：https://leetcode.cn/problems/next-greater-element-i/solution/xia-yi-ge-geng-da-yuan-su-i-by-leetcode-bfcoj/
     */

}
