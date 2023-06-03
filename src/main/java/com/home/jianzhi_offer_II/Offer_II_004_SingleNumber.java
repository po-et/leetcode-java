package com.home.jianzhi_offer_II;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 004. 只出现一次的数字
 *
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 * 示例 1：
 * 输入：nums = [2,2,3,2]
 * 输出：3
 *
 * 示例 2：
 * 输入：nums = [0,1,0,1,0,1,100]
 * 输出：100
 *
 * 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 注意：本题与主站 137 题相同：https://leetcode-cn.com/problems/single-number-ii/
 *
 * @see <a href="https://leetcode.cn/problems/WGki4K" />
 * @author Poet
 * @date 2023/3/13
 */
public class Offer_II_004_SingleNumber {

    /**
     * 方法一：哈希表
     *
     * time:  O(n)
     * space: O(n)
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (freq.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }

    /**
     * 方法二：依次确定每一个二进制位
     *
     * time:  O(nlogC) logC = 32
     * space: O(1)
     */
    public int singleNumber_2(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

}
