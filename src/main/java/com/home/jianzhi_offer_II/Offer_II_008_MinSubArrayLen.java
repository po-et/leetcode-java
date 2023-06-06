package com.home.jianzhi_offer_II;

/**
 * 剑指 Offer II 008. 和大于等于 target 的最短子数组
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 *
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 * @see <a href="https://leetcode.cn/problems/2VG8Kg" />
 * @author Poet
 * @date 2023/3/14
 */
public class Offer_II_008_MinSubArrayLen {

    /**
     * 方法一：前缀和 + 二分查找
     */

    /**
     * 方法二：滑动窗口
     *
     * time:  O(n)
     * space: O(1)
     */
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int start = 0, end = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;

        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                res = Math.min(res, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }


    /**
     * 暴力解法（自己ac）
     */
    public int minSubArrayLen_bruteForce(int target, int[] nums) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            if (sum >= target) {
                return 1;
            }
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                if (sum >= target) {
                    res = Math.min(res, j - i + 1);
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
