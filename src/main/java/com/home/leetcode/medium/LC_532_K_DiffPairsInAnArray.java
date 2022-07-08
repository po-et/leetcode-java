package com.home.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 532. K-diff Pairs in an Array
 *
 * Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
 *
 * A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
 *
 *      0 <= i, j < nums.length
 *      i != j
 *      nums[i] - nums[j] == k
 * Notice that |val| denotes the absolute value of val.
 *
 * Example 1:
 * Input: nums = [3,1,4,1,5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 *
 * Example 2:
 * Input: nums = [1,2,3,4,5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 *
 * Example 3:
 * Input: nums = [1,3,1,5,4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 *
 * @see <a href="https://leetcode.cn/problems/k-diff-pairs-in-an-array" />
 * @author poet
 * @date 2022/6/16
 */
public class LC_532_K_DiffPairsInAnArray {

    /**
     * 方法一：哈希表
     *
     * time:  O(n) 其中 n 是数组 nums 的长度
     * space: O(n)
     */
    public int findPairs(int[] nums, int k) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int num : nums) {
            if (visited.contains(num - k)) {
                res.add(num - k);
            }
            if (visited.contains(num + k)) {
                res.add(num);
            }
            visited.add(num);
        }
        return res.size();
    }

    /**
     * 方法二：排序 + 双指针
     *
     * time:  O(nlogn) 其中 n 是数组 nums 的长度
     * space: O(logn) 排序消耗 O(logn) 复杂度
     */
    public int findPairs_2_sort(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0, j = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (j <= i || (j < n && nums[j] < nums[i] + k)) {
                j++;
            }
            if (j < n && nums[j] == nums[i] + k) {
                res++;
            }
        }
        return res;
    }

}
