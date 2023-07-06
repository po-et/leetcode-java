package com.home.jianzhi_offer_II;

/**
 * 剑指 Offer II 068. 查找插入位置
 *
 * 给定一个排序的整数数组 nums 和一个整数目标值 target ，请在数组中找到 target ，并返回其下标。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 * 示例 4:
 * 输入: nums = [1,3,5,6], target = 0
 * 输出: 0
 *
 * 示例 5:
 * 输入: nums = [1], target = 0
 * 输出: 0
 *
 * 注意：本题与主站 35 题相同： https://leetcode-cn.com/problems/search-insert-position/
 *
 * @see <a href="https://leetcode.cn/problems/N6YdxV/" />
 * @author Poet
 * @date 2023/4/4
 */
public class Offer_II_068_SearchInsertPosition {

    // 题目本质为：「在一个有序数组中找第一个大于等于 target 的下标」

    /**
     * 方法一：二分查找
     *
     * time:  O(logN)
     * space: O(1)
     */
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int res = n;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target <= nums[mid]) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

}
