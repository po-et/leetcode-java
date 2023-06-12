package com.home.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 2475. Number of Unequal Triplets in Array (数组中不等三元组的数目)
 *
 * You are given a 0-indexed array of positive integers nums. Find the number of triplets (i, j, k) that meet the following conditions:
 *
 * 0 <= i < j < k < nums.length
 * nums[i], nums[j], and nums[k] are pairwise distinct.
 * In other words, nums[i] != nums[j], nums[i] != nums[k], and nums[j] != nums[k].
 * Return the number of triplets that meet the conditions.
 *
 * Example 1:
 * Input: nums = [4,4,2,4,3]
 * Output: 3
 * Explanation: The following triplets meet the conditions:
 * - (0, 2, 4) because 4 != 2 != 3
 * - (1, 2, 4) because 4 != 2 != 3
 * - (2, 3, 4) because 2 != 4 != 3
 * Since there are 3 triplets, we return 3.
 * Note that (2, 0, 4) is not a valid triplet because 2 > 0.
 *
 * Example 2:
 * Input: nums = [1,1,1,1,1]
 * Output: 0
 * Explanation: No triplets meet the conditions so we return 0.
 *
 * @see <a href="https://leetcode.cn/problems/number-of-unequal-triplets-in-array/" />
 * @author Poet
 * @date 2023/6/13
 */
public class LC_2475_NumberOfUnequalTripletsInArray {

    /**
     * 方法一：枚举（暴力解法）
     *
     * time:  O(N^3)
     * space: O(1)
     */
    public int unequalTriplets(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 方法三：哈希表
     *
     * time:  O(N)
     * space: O(N)
     */
    public int unequalTriplets_3(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        int n = nums.length;
        // 先前遍历的元素总数目t
        int pre = 0;
        // 当前遍历的元素数目 v
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 那么以当前遍历的元素为中间元素的符合条件的三元组数目为： t×v×(n−t−v)
            res += pre * entry.getValue() * (n - pre - entry.getValue());
            pre += entry.getValue();
        }
        return res;
    }
}
