package com.home.leetcode.medium;

/**
 * 915. Partition Array into Disjoint Intervals （分割数组）
 *
 * Given an integer array nums, partition it into two (contiguous) subarrays left and right so that:
 *      - Every element in left is less than or equal to every element in right.
 *      - left and right are non-empty.
 *      - left has the smallest possible size.
 *
 * Return the length of left after such a partitioning.
 *
 * Test cases are generated such that partitioning exists.
 *
 * Example 1:
 * Input: nums = [5,0,3,8,6]
 * Output: 3
 * Explanation: left = [5,0,3], right = [8,6]
 *
 * Example 2:
 * Input: nums = [1,1,1,0,6,12]
 * Output: 4
 * Explanation: left = [1,1,1,0], right = [6,12]
 *
 * @see <a href="https://leetcode.cn/problems/partition-array-into-disjoint-intervals/" />
 * @author Poet
 * @date 2022/10/24
 */
public class LC_915_PartitionArrayIntoDisjointIntervals {

    /**
     * 方法一：两次遍历
     */
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] minRight = new int[n];
        minRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(nums[i], minRight[i + 1]);
        }

        int maxLeft = 0;
        for (int i = 0; i < n - 1; i++) {
            maxLeft = Math.max(maxLeft, nums[i]);
            if (maxLeft <= minRight[i + 1]) {
                return i + 1;
            }
        }
        // 题目保证一定有解
        return n - 1;
    }

}
