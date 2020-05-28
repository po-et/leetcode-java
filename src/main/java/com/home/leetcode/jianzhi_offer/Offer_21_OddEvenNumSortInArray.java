package com.home.leetcode.jianzhi_offer;

/**
 * 面试题21. 调整数组顺序使奇数位于偶数前面
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * @author Poet
 * @date 2020/5/28
 */
public class Offer_21_OddEvenNumSortInArray {

    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int l = 0, r = nums.length - 1;

        while (l < r) {
            while (l < nums.length - 1 && !isEven(nums[l])) {
                l++;
            }
            while (r > 0 && isEven(nums[r])) {
                r--;
            }
            if (l >= r) {
                break;
            }
            swap(nums, l, r);
        }
        return nums;
    }

    private boolean isEven(int num) {
        return (num & 0x1) == 0;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
}
