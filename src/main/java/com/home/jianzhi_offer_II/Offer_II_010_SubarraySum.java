package com.home.jianzhi_offer_II;

/**
 * 剑指 Offer II 010. 和为 k 的子数组
 *
 * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
 *
 * 示例 1：
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2
 * 解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
 *
 * 示例 2：
 * 输入:nums = [1,2,3], k = 3
 * 输出: 2
 *
 * 注意：本题与主站 560 题相同： https://leetcode-cn.com/problems/subarray-sum-equals-k/
 *
 * @see <a href="https://leetcode.cn/problems/QTMn0o" />
 * @author Poet
 * @date 2023/3/15
 */
public class Offer_II_010_SubarraySum {

    /**
     * 方法一：枚举（暴力解法）
     *
     * time:  O(n^2)
     * space: O(1)
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 方法二：前缀和 + 哈希表优化
     */
    // 再次学习题解：https://leetcode.cn/problems/QTMn0o/solution/he-wei-k-de-zi-shu-zu-by-leetcode-soluti-1169/

}
