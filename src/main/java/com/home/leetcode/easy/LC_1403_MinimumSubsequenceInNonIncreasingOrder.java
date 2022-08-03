package com.home.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1403. Minimum Subsequence in Non-Increasing Order (非递增顺序的最小子序列)
 * 
 * Given the array nums, obtain a subsequence of the array whose sum of elements is strictly greater than the sum of the non included elements in such subsequence. 
 *
 * If there are multiple solutions, return the subsequence with minimum size and if there still exist multiple solutions, return the subsequence with the maximum total sum of all its elements. A subsequence of an array can be obtained by erasing some (possibly zero) elements from the array. 
 *
 * Note that the solution with the given constraints is guaranteed to be unique. Also return the answer sorted in non-increasing order.
 *
 * Example 1:
 * Input: nums = [4,3,10,9,8]
 * Output: [10,9] 
 * Explanation: The subsequences [10,9] and [10,8] are minimal such that the sum of their elements is strictly greater than the sum of elements not included, however, the subsequence [10,9] has the maximum total sum of its elements.
 *
 * Example 2:
 * Input: nums = [4,4,7,6,7]
 * Output: [7,7,6] 
 * Explanation: The subsequence [7,7] has the sum of its elements equal to 14 which is not strictly greater than the sum of elements not included (14 = 4 + 4 + 6). Therefore, the subsequence [7,6,7] is the minimal satisfying the conditions. Note the subsequence has to returned in non-decreasing order.
 *
 * Example 3:
 * Input: nums = [6]
 * Output: [6]
 *
 * @see <a href="https://leetcode.cn/problems/minimum-subsequence-in-non-increasing-order" />
 * @author Poet
 * @date 2022/8/4
 */
public class LC_1403_MinimumSubsequenceInNonIncreasingOrder {

    /**
     * 方法一：贪心算法
     *
     * time:  O(nlogn) 其中 n 为 数组的长度。需要对数组进行排序，因此时间复杂度为 O(nlogn)
     * space: O(logn)  其中 n 为 数组的长度。排序需要的栈空间为 O(logn)
     */
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);

        List<Integer> res = new ArrayList<>();
        int sum = Arrays.stream(nums).sum();
        int subSum = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            subSum += nums[i];
            res.add(nums[i]);
            if (subSum > sum - subSum) {
                break;
            }
        }
        return res;
    }
}
