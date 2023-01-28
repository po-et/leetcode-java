package com.home.leetcode.medium;

/**
 * 1664. Ways to Make a Fair Array （生成平衡数组的方案数）
 *
 * You are given an integer array nums. You can choose exactly one index (0-indexed) and remove the element. Notice that the index of the elements may change after the removal.
 *
 * For example, if nums = [6,1,7,4,1]:
 * Choosing to remove index 1 results in nums = [6,7,4,1].
 * Choosing to remove index 2 results in nums = [6,1,4,1].
 * Choosing to remove index 4 results in nums = [6,1,7,4].
 *
 * An array is fair if the sum of the odd-indexed values equals the sum of the even-indexed values.
 *
 * Return the number of indices that you could choose such that after the removal, nums is fair.
 *
 * Example 1:
 * Input: nums = [2,1,6,4]
 * Output: 1
 * Explanation:
 * Remove index 0: [1,6,4] -> Even sum: 1 + 4 = 5. Odd sum: 6. Not fair.
 * Remove index 1: [2,6,4] -> Even sum: 2 + 4 = 6. Odd sum: 6. Fair.
 * Remove index 2: [2,1,4] -> Even sum: 2 + 4 = 6. Odd sum: 1. Not fair.
 * Remove index 3: [2,1,6] -> Even sum: 2 + 6 = 8. Odd sum: 1. Not fair.
 * There is 1 index that you can remove to make nums fair.
 *
 * Example 2:
 * Input: nums = [1,1,1]
 * Output: 3
 * Explanation: You can remove any index and the remaining array is fair.
 *
 * Example 3:
 * Input: nums = [1,2,3]
 * Output: 0
 * Explanation: You cannot make a fair array after removing any index.
 *
 * @see <a href="https://leetcode.cn/problems/ways-to-make-a-fair-array/" />
 * @author Poet
 * @date 2023/1/28
 */
public class LC_1664_WaysToMakeAFairArray {

    /**
     * 方法一：动态规划
     *
     * time:  O(n)
     * space: O(1) 用「滚动数组」的技巧来进行空间优化，仅使用常量空间
     */
    public int waysToMakeFair(int[] nums) {
        int odd1 = 0, even1 = 0;
        int odd2 = 0, even2 = 0;
        for (int i = 0; i < nums.length; ++i) {
            if ((i & 1) != 0) {
                odd2 += nums[i];
            } else {
                even2 += nums[i];
            }
        }

        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if ((i & 1) != 0) {
                odd2 -= nums[i];
            } else {
                even2 -= nums[i];
            }
            if (odd1 + even2 == odd2 + even1) {
                ++res;
            }
            if ((i & 1) != 0) {
                odd1 += nums[i];
            } else {
                even1 += nums[i];
            }
        }
        return res;
    }




    /**
     * 暴力解法（超时）
     */
    public int waysToMakeFair_timeout(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int evenSum = 0;
            int oddSum = 0;
            for (int j = 0; j < n; j++) {
                if (j < i) {
                    if (isEven(j)) {
                        evenSum += nums[j];
                    } else {
                        oddSum += nums[j];
                    }
                } else if (j > i) {
                    if (isEven(j)) {
                        oddSum += nums[j];
                    } else {
                        evenSum += nums[j];
                    }
                }
            }
            if (oddSum == evenSum) {
                res++;
            }
        }
        return res;
    }

    private boolean isEven(int num) {
        return (num & 0x1) == 0;
    }
}
