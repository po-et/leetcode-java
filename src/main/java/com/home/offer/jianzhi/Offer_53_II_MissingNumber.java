package com.home.offer.jianzhi;

/**
 * 面试题53 - II. 0～n-1中缺失的数字
 *
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 *
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * @author Poet
 * @date 2020/6/14
 */
public class Offer_53_II_MissingNumber {

    /**
     * 二分法
     *
     * 左子数组： nums[i]  =  nums[i]
     * 右子数组： nums[i] \ne nums[i]
     *
     * 缺失的数字等于 “右子数组的首位元素” 对应的索引；因此考虑使用二分法查找 “右子数组的首位元素”
     *
     * 题解 https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/solution/mian-shi-ti-53-ii-0n-1zhong-que-shi-de-shu-zi-er-f/
     *
     * time:  O(log N)
     * space: O(1)
     */
    public int missingNumber(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + ((r - l) >> 1);

            if (nums[mid] == mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

}
