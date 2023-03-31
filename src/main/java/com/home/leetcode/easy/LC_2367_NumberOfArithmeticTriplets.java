package com.home.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 2367. Number of Arithmetic Triplets
 *
 * You are given a 0-indexed, strictly increasing integer array nums and a positive integer diff. A triplet (i, j, k) is an arithmetic triplet if the following conditions are met:
 *      - i < j < k,
 *      - nums[j] - nums[i] == diff, and
 *      - nums[k] - nums[j] == diff.
 *
 * Return the number of unique arithmetic triplets.
 *
 * Example 1:
 * Input: nums = [0,1,4,6,7,10], diff = 3
 * Output: 2
 * Explanation:
 * (1, 2, 4) is an arithmetic triplet because both 7 - 4 == 3 and 4 - 1 == 3.
 * (2, 4, 5) is an arithmetic triplet because both 10 - 7 == 3 and 7 - 4 == 3.
 *
 * Example 2:
 * Input: nums = [4,5,6,7,8,9], diff = 2
 * Output: 2
 * Explanation:
 * (0, 2, 4) is an arithmetic triplet because both 8 - 6 == 2 and 6 - 4 == 2.
 * (1, 3, 5) is an arithmetic triplet because both 9 - 7 == 2 and 7 - 5 == 2.
 *
 * @see <a href="https://leetcode.cn/problems/number-of-arithmetic-triplets/" />
 * @author Poet
 * @date 2023/3/31
 */
public class LC_2367_NumberOfArithmeticTriplets {

    /**
     * 方法一：暴力枚举
     *
     * time:  O(N^3)
     * space: O(1)
     */
    public int arithmeticTriplets(int[] nums, int diff) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] - nums[i] != diff) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (nums[k] - nums[j] == diff) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 方法二：哈希集合
     *
     * time:  O(N)
     * space: O(N)
     */
    public int arithmeticTriplets_2(int[] nums, int diff) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (int num : nums) {
            if (set.contains(num + diff) && set.contains(num + diff * 2)) {
                res++;
            }
        }
        return res;
    }
}
