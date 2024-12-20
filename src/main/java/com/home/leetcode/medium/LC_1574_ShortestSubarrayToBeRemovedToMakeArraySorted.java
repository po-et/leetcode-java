package com.home.leetcode.medium;

/**
 * 1574. Shortest Subarray to be Removed to Make Array Sorted（删除最短的子数组使剩余数组有序）
 *
 * Given an integer array arr, remove a subarray (can be empty) from arr such that the remaining elements in arr are non-decreasing.
 *
 * Return the length of the shortest subarray to remove.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 * Example 1:
 * Input: arr = [1,2,3,10,4,2,3,5]
 * Output: 3
 * Explanation: The shortest subarray we can remove is [10,4,2] of length 3. The remaining elements after that will be [1,2,3,3,5] which are sorted.
 * Another correct solution is to remove the subarray [3,10,4].
 *
 * Example 2:
 * Input: arr = [5,4,3,2,1]
 * Output: 4
 * Explanation: Since the array is strictly decreasing, we can only keep a single element. Therefore we need to remove a subarray of length 4, either [5,4,3,2] or [4,3,2,1].
 *
 * Example 3:
 * Input: arr = [1,2,3]
 * Output: 0
 * Explanation: The array is already non-decreasing. We do not need to remove any elements.
 *
 * @author Poet
 * @date 2023/3/25
 */
public class LC_1574_ShortestSubarrayToBeRemovedToMakeArraySorted {

    /**
     * 方法一：双指针
     *
     * time:  O(n)
     * space: O(1)
     */
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        int r = n - 1;
        while (r > 0 && arr[r - 1] <= arr[r]) {
            r--;
        }
        if (r == 0) {
            return 0;
        }

        int res = r;
        for (int l = 0; l < n; l++) {
            while (r < n && arr[r] < arr[l]) {
                r++;
            }
            res = Math.min(res, r - l - 1);
            if (l < n - 1 && arr[l] > arr[l + 1]) {
                break;
            }
        }
        return res;
    }
}
