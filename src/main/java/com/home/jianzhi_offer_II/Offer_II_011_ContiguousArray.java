package com.home.jianzhi_offer_II;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 011. 0 和 1 个数相同的子数组
 *
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 * 示例 1：
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 *
 * 示例 2：
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。
 *
 * 注意：本题与主站 525 题相同： https://leetcode-cn.com/problems/contiguous-array/
 *
 * @see <a href="https://leetcode.cn/problems/A1NYOS" />
 * @author Poet
 * @date 2023/3/15
 */
public class Offer_II_011_ContiguousArray {

    /**
     * 方法一：前缀和 + 哈希表
     *
     * 题解：https://leetcode.cn/problems/A1NYOS/solution/by-ac_oier-lmmo/
     *
     * time:  O(n)
     * space: O(n)
     */
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int res = 0;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 1; i <= n; i++) {
            int t = sum[i];
            if (map.containsKey(t)) {
                res = Math.max(res, i - map.get(t));
            } else {
                map.put(t, i);
            }
        }
        return res;
    }
}
