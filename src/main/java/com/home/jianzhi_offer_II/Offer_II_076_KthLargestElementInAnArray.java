package com.home.jianzhi_offer_II;

import java.util.Random;

/**
 * 剑指 Offer II 076. 数组中的第 k 大的数字
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 注意：本题与主站 215 题相同： https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 *
 * @see <a href="https://leetcode.cn/problems/xx4gT2/" />
 * @author Poet
 * @date 2023/4/13
 */
public class Offer_II_076_KthLargestElementInAnArray {

    /**
     * 方法一：基于快速排序的选择方法
     *
     * time:  O(N)
     * space: O(logN)
     */
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int l, int r, int index) {
        int pivot = randomPartition(nums, l, r);
        if (pivot == index) {
            return nums[pivot];
        } else {
            return pivot < index ? quickSelect(nums, pivot + 1, r, index) : quickSelect(nums, l, pivot - 1, index);
        }
    }

    private int randomPartition(int[] nums, int l, int r) {
        int idx = random.nextInt(r - l + 1) + l;
        swap(nums, idx, r);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int x = nums[r];
        int start = l - 1;
        for (int i = l; i < r; i++) {
            if (nums[i] <= x) {
                start++;
                swap(nums, start, i);
            }
        }
        swap(nums, start + 1, r);
        return start + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 方法二：基于堆排序的选择方法
     */

}
