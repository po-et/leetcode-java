package com.home.leetcode.medium;

/**
 * 152. Maximum Product Subarray
 *
 * Given an integer array nums, find a subarray that has the largest product, and return the product.
 *
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * Example 1:
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 * Example 2:
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * @see <a href="https://leetcode.cn/problems/maximum-product-subarray/" />
 * @author Poet
 * @date 2022/11/12
 */
public class LC_152_MaximumProductSubarray {

    /**
     * “最大子数组和”是DP算法里的经典案例之一，经典到这个解法甚至有一个名称Kadane's Algorithm。本题是“最大子数组和”的变型，但Kadane's Algo依然适用。
     * 唯一要注意的是“乘法”下由于两个负数的乘积也依然可能得到一个很大的正数，所以必须同时计算“最小子数组和”，除此之外无任何区别。
     *
     * Kadane's Algo变型可以解决问题还有：
     *  1186. 删除一次得到子数组最大和 - Medium
     *  1191. K 次串联后最大子数组之和 - Hard
     */
    public int maxProduct(int[] nums) {

        return -1;
    }
}
