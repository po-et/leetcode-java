package com.home.leetcode.easy;

/**
 * 35. Search Insert Position
 *
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 *
 * Example 2:
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 *
 * Example 3:
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 *
 * @see <a href="https://leetcode.cn/problems/search-insert-position/" />
 * Created by Poet on 2019-01-15.
 */
public class LC_035_SearchInsertPosition {

    // 本质问题：
    // 「在一个有序数组中找第一个大于等于 target 的下标」

    /**
     * 方法一：二分查找
     *
     * time:  O(logn)
     * space: O(1)
     */
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = nums.length - 1;
        int res = n;  // res初值设置为数组长度可以省略边界条件的判断。因为存在一种情况是target大于数组中的所有数，此时需要插入到数组长度的位置。

        while (l <= r) {
            int mid = l + ((r - l) >> 1);
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
