package com.home.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 1814. Count Nice Pairs in an Array (统计一个数组中好对子的数目)
 *
 * You are given an array nums that consists of non-negative integers. Let us define rev(x) as the reverse of the non-negative integer x.
 * For example, rev(123) = 321, and rev(120) = 21.
 * A pair of indices (i, j) is nice if it satisfies all of the following conditions:
 *  - 0 <= i < j < nums.length
 *  - nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 *
 * Return the number of nice pairs of indices. Since that number can be too large, return it modulo 109 + 7.
 *
 * Example 1:
 * Input: nums = [42,11,1,97]
 * Output: 2
 * Explanation: The two pairs are:
 *  - (0,3) : 42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121.
 *  - (1,2) : 11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12.
 *
 * Example 2:
 * Input: nums = [13,10,35,24,76]
 * Output: 4
 *
 * @see <a href="https://leetcode.cn/problems/count-nice-pairs-in-an-array/" />
 * @author Poet
 * @date 2023/1/17
 */
public class LC_1814_CountNicePairsInAnArray {

    /**
     * 方法一：哈希表
     *
     * time:  O(n×logC)
     * space: O(n)
     *
     */
    public int countNicePairs(int[] nums) {
        final int MOD = 1_000_000_007;
        int res = 0;
        Map<Integer, Integer> h = new HashMap<>();
        for (int num : nums) {
            int temp = num;
            int rev = 0;
            while (temp > 0) {
                rev = rev * 10 + temp % 10;
                temp /= 10;
            }
            res = (res + h.getOrDefault(num - rev, 0)) % MOD;
            h.put(num - rev, h.getOrDefault(num - rev, 0) + 1);
        }
        return res;
    }






    // 自己完成，超时了
    private Map<Integer, Integer> reverseMap = new HashMap<>();
    public int countNicePairs_timeout(int[] nums) {
        int res = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + reverse(nums[j]) == nums[j] + reverse(nums[i])) {
                    res++;
                }
            }
        }
        return res;
    }

    private int reverse(int num) {
        if (reverseMap.containsKey(num)) {
            return reverseMap.get(num);
        }

        StringBuilder builder = new StringBuilder();
        String str = num + "";
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                continue;
            }
            builder.append(str.charAt(i));
        }

        int res = Integer.parseInt(builder.toString());
        reverseMap.put(num, res);
        return res;
    }

}
