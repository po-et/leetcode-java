package com.home.offer.jianzhi;

/**
 * 面试题53 - I. 在排序数组中查找数字 I
 *
 * 统计一个数字在排序数组中出现的次数。
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 *
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * @author Poet
 * @date 2020/6/14
 */
public class Offer_53_I_FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;
        System.out.println(search(nums, target));
    }


    public static int search(int[] nums, int target) {
        int floor = floor(nums, nums.length, target);

        int count = 0;

        while (floor >=0 && floor < nums.length && nums[floor] == target) {
            count ++;
            floor ++;
        }
        return count;
    }

    // 寻找floor
    public static int floor(int[] nums, int n, int target) {

        int l = -1;
        int r = n - 1;

        while (l < r) {
            int mid = l + (r - l + 1) /2;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }

        if (l + 1 < n && nums[l + 1] == target) {
            return l + 1;
        }
        return l;
    }

}
