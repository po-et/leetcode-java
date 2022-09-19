package com.home.leetcode.easy;

import java.util.*;

/**
 * 1636. Sort Array by Increasing Frequency
 *
 * Given an array of integers nums, sort the array in increasing order based on the frequency of the values.
 * If multiple values have the same frequency, sort them in decreasing order.
 *
 * Return the sorted array.
 *
 * Example 1:
 * Input: nums = [1,1,2,2,2,3]
 * Output: [3,1,1,2,2,2]
 * Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
 *
 * Example 2:
 * Input: nums = [2,3,1,3,2]
 * Output: [1,3,3,2,2]
 * Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
 *
 * Example 3:
 * Input: nums = [-1,1,-6,4,5,-6,1,4,1]
 * Output: [5,-1,4,4,-6,-6,1,1,1]
 *
 * @see <a href="https://leetcode.cn/problems/sort-array-by-increasing-frequency/" />
 * @author Poet
 * @date 2022/9/19
 */
public class LC_1636_SortArrayByIncreasingFrequency {

    /**
     * 按照频率将数组升序排序
     *
     * time:  O(nlogn)
     * space: O(n)
     */
    public int[] frequencySort(int[] nums) {
        int n = nums.length;

        // 计算频率
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> data = new ArrayList<>();
        for (int num : nums) {
            data.add(num);
        }
        // 排序
        Collections.sort(data, (a, b) -> {
            int cnt1 = cnt.get(a);
            int cnt2 = cnt.get(b);
            return cnt1 != cnt2 ? cnt1 - cnt2 : b - a;
        });

        for (int i = 0; i < n; i++) {
            nums[i] = data.get(i);
        }
        return nums;
    }

}
