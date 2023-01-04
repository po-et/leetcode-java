package com.home.leetcode.medium;

/**
 * 1802. Maximum Value at a Given Index in a Bounded Array
 *
 * You are given three positive integers: n, index, and maxSum. You want to construct an array nums (0-indexed) that satisfies the following conditions:
 *  - nums.length == n
 *  - nums[i] is a positive integer where 0 <= i < n.
 *  - abs(nums[i] - nums[i+1]) <= 1 where 0 <= i < n-1.
 *  - The sum of all the elements of nums does not exceed maxSum.
 *  - nums[index] is maximized.
 *
 * Return nums[index] of the constructed array.
 *
 * Note that abs(x) equals x if x >= 0, and -x otherwise.
 *
 * Example 1:
 * Input: n = 4, index = 2,  maxSum = 6
 * Output: 2
 * Explanation: nums = [1,2,2,1] is one array that satisfies all the conditions.
 * There are no arrays that satisfy all the conditions and have nums[2] == 3, so 2 is the maximum nums[2].
 *
 * Example 2:
 * Input: n = 6, index = 1,  maxSum = 10
 * Output: 3
 *
 * @see <a href="https://leetcode.cn/problems/maximum-value-at-a-given-index-in-a-bounded-array/" />
 * @author Poet
 * @date 2023/1/4
 */
public class LC_1802_MaximumValueAtAGivenIndexInABoundedArray {

    // 参考答案

    /**
     * 方法一：贪心 + 二分查找
     */
    public int maxValue(int n, int index, int maxSum) {
        int left = 1, right = maxSum;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (valid(mid, n, index, maxSum)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean valid(int mid, int n, int index, int maxSum) {
        int left = index;
        int right = n - index - 1;
        return mid + cal(mid, left) + cal(mid, right) <= maxSum;
    }

    public long cal(int big, int length) {
        if (length + 1 < big) {
            int small = big - length;
            return (long) (big - 1 + small) * length / 2;
        } else {
            int ones = length - (big - 1);
            return (long) big * (big - 1) / 2 + ones;
        }
    }
}
