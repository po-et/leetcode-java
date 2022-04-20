package com.home.offer.jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题39. 数组中出现次数超过一半的数字
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 * @author Poet
 * @date 2020/5/31
 */
public class Offer_39_MajorityElement {

    /**
     * 方法三：摩尔投票法 （Best！！！）
     * 核心理念为 “正负抵消” ；时间和空间复杂度分别为O(N)和O(1) ；本题的最佳解法。
     */
    public int majorityElement(int[] nums) {
        int votes = 0;
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            if (votes == 0)
                x = nums[i];

            if(nums[i] == x)
                votes += 1;
            else
                votes -= 1;
        }

        // 验证 x 是否为众数 (如果题目没有明确表明有众数，则需要验证)
        int count = 0;
        for(int num : nums)
            if(num == x) count++;

        return count > nums.length / 2 ? x : 0; // 当无众数时返回 0
    }

    /**
     * 方法一：哈希表统计法
     * Time: O(N)
     * Space: O(N)
     */
    public int majorityElement1(int[] nums) {
        int len = nums.length;
        int mid = len / 2;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < len; i++) {
             freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > mid) {
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     * 方法二：数组排序法
     * 将数组 nums 排序，由于众数的数量超过数组长度一半，因此 数组中点的元素 一定为众数。此方法时间复杂度 O(N log_2 N)
     */

}
