package com.home.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 136. Single Number (只出现一次的数字)
 * 
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * Example 1:
 * Input: nums = [2,2,1]
 * Output: 1
 *
 * Example 2:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 *
 * Example 3:
 * Input: nums = [1]
 * Output: 1
 *
 * @see <a href="https://leetcode.cn/problems/single-number" />
 * @author Poet
 * @date 2022/6/12
 */
public class LC_136_SingleNumber {

    /**
     * 方法一：位运算（异或）
     *
     * 异或运算有以下三个性质。
     *
     * 1、任何数和0做异或运算，结果仍然是原来的数，即 a⊕0=a。
     * 2、任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
     * 3、异或运算满足交换律和结合律，即 a⊕b⊕a = b⊕a⊕a = b⊕(a⊕a) = b⊕0 = b。
     *
     * 官方题解：https://leetcode.cn/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/
     *
     * time:  O(n)
     * space: O(1)
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single = single ^ num;
        }
        return single;
    }

    /**
     * 方法二：哈希表
     */
    public int singleNumber_hashtable(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;  // no solution
    }
}
