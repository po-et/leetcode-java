package com.home.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2357. Make Array Zero by Subtracting Equal Amounts (使数组中所有元素都等于零)
 *
 * You are given a non-negative integer array nums. In one operation, you must:
 *
 * Choose a positive integer x such that x is less than or equal to the smallest non-zero element in nums.
 * Subtract x from every positive element in nums.
 * Return the minimum number of operations to make every element in nums equal to 0.
 *
 * Example 1:
 * Input: nums = [1,5,0,3,5]
 * Output: 3
 * Explanation:
 * In the first operation, choose x = 1. Now, nums = [0,4,0,2,4].
 * In the second operation, choose x = 2. Now, nums = [0,2,0,0,2].
 * In the third operation, choose x = 2. Now, nums = [0,0,0,0,0].
 *
 * Example 2:
 * Input: nums = [0]
 * Output: 0
 * Explanation: Each element in nums is already 0 so no operations are needed.
 *
 * @author Poet
 * @date 2023/2/24
 */
public class LC_2357_MakeArrayZeroBySubtractingEqualAmounts {

    /**
     * 方法一：排序 + 模拟
     *
     * 贪心策略
     *
     * time:  O(n^2)
     * space: O(logn)
     */
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                int x = nums[i];
                for (int j = i; j < n; j++) {
                    nums[j] = nums[j] - x;
                }
                res++;
            }
        }
        return res;
    }

    /**
     * 方法二：哈希集合
     *
     * time:  O(n)
     * space: O(n)
     */
    public int minimumOperations_2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        return set.size();
    }

}
