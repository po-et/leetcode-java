package com.home.leetcode.easy;

/**
 * 1089. Duplicate Zeros
 *
 * Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
 *
 * Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.
 *
 * Example 1:
 * Input: arr = [1,0,2,3,0,4,5,0]
 * Output: [1,0,0,2,3,0,0,4]
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 *
 * Example 2:
 * Input: arr = [1,2,3]
 * Output: [1,2,3]
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 *
 * @see <a href="https://leetcode.cn/problems/duplicate-zeros" />
 * @author poet
 * @date 2022/6/17
 */
public class LC_1089_DuplicateZeros {

    /**
     * time:  O(n)
     * space: O(n)
     */
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int[] copy = new int[n];

        // [0...idx] 表示复写0之后的结果
        int idx = 0;

        for (int i = 0; i < n && idx < n; i++) {
            copy[idx] = arr[i];
            idx ++;

            if (arr[i] == 0) {
                copy[idx] = 0;
                idx ++;
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = copy[i];
        }
    }

}
