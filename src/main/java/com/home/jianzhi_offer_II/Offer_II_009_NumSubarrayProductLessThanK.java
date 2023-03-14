package com.home.jianzhi_offer_II;

/**
 * 剑指 Offer II 009. 乘积小于 K 的子数组
 *
 * 给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
 *
 * 示例 1:
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 *
 * 示例 2:
 * 输入: nums = [1,2,3], k = 0
 * 输出: 0
 *
 * 注意：本题与主站 713 题相同：https://leetcode-cn.com/problems/subarray-product-less-than-k/
 *
 * @see <a href="https://leetcode.cn/problems/ZVAVXX" />
 * @author Poet
 * @date 2023/3/14
 */
public class Offer_II_009_NumSubarrayProductLessThanK {

    /**
     * 方法一：二分查找
     */


    /**
     * 方法二：滑动窗口
     *
     * time:  O(n)
     * space: O(1)
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        int product = 1;
        int start = 0, end = 0;
        while (end < n) {
            product *= nums[end];
            while (start <= end && product >= k) {
                product /= nums[start];
                start++;
            }
            res += end - start + 1;
            end++;
        }
        return res;
    }

}
