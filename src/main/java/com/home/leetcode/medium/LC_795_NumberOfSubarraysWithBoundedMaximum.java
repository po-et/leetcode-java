package com.home.leetcode.medium;

/**
 * 795. Number of Subarrays with Bounded Maximum
 *
 * Given an integer array nums and two integers left and right, return the number of contiguous non-empty subarrays
 * such that the value of the maximum array element in that subarray is in the range [left, right].
 *
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * Example 1:
 * Input: nums = [2,1,4,3], left = 2, right = 3
 * Output: 3
 * Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
 *
 * Example 2:
 * Input: nums = [2,9,2,5,6], left = 2, right = 8
 * Output: 7
 *
 * @see <a href="https://leetcode.cn/problems/number-of-subarrays-with-bounded-maximum/" />
 * @author Poet
 * @date 2022/11/24
 */
public class LC_795_NumberOfSubarraysWithBoundedMaximum {

    /* --- 这道题来自：Weekly Contest 74 --- */

    // 参考答案
    /**
     * 方法一：遍历
     *
     * 求出最大值不大于right的子数组数量，以及最大值不大于left-1的子数组数量，前者中多出的就是后者，相减即可
     */
    /*
    @可爱抱抱呀
    执行用时：3 ms, 在所有 Java 提交中击败了90.58%的用户
    内存消耗：49 MB, 在所有 Java 提交中击败了44.07%的用户
    2022年11月23日 10:52

    solution: https://leetcode.cn/problems/number-of-subarrays-with-bounded-maximum/solution/qu-jian-zi-shu-zu-ge-shu-by-leetcode-sol-7it1/
    */
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return (int) (subArray(nums, right) - subArray(nums, left - 1));
    }

    long subArray(int nums[], int max) {
        //计算最大值不大于max的子数组数量
        long ans = 0;
        int l = 0, r = 0, n = nums.length;
        while (l < n) {
            while (l < n && nums[l] > max) {l++;}
            r = l;
            while (r < n && nums[r] <= max) {r++;}
            ans += (long) (r - l) * (r - l + 1);
            l = r;
        }
        return ans >> 1;
    }

}
