package com.home.jianzhi_offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * 
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 * 示例1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 * 示例2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * @see <a href="https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof" />
 * @author Poet
 * @date 2022/6/20
 */
public class Offer_61_IsStraightInPoker {

    /**
     * 方法一： 集合 Set + 遍历
     *
     * time:  O(N) = O(5) = O(1)
     * space: O(N) = O(5) = O(1)
     */
    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int min = 14, max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {     // 跳过大小王
                continue;
            }
            if (repeat.contains(nums[i])) {     // 若有重复，提前返回 false
                return false;
            }
            repeat.add(nums[i]);            // 添加此牌至 Set
            min = Math.min(min, nums[i]);   // 最小牌
            max = Math.max(max, nums[i]);   // 最大牌
        }
        return max - min < 5;   // 最大牌 - 最小牌 < 5 则可构成顺子
    }


    /**
     * 方法二：排序 + 遍历
     *
     * time:  O(NlogN)
     * space: O(1)
     */
    public boolean isStraight_2(int[] nums) {
        int zero = 0;
        Arrays.sort(nums);  // 数组排序

        for (int i = 0; i < nums.length - 1; i++) {  // 统计大小王数量
            if (nums[i] == 0) {
                zero++;
            } else if (nums[i + 1] == nums[i]) {    // 若有重复，提前返回 false
                return false;
            }
        }
        return nums[4] - nums[zero] < 5;    // 最大牌 - 最小牌 < 5 则可构成顺子
    }
}
