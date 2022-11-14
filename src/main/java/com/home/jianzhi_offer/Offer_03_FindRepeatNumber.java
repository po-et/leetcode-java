package com.home.jianzhi_offer;

/**
 * 面试题03. 数组中重复的数字
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * @see <a href="https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof" />
 * @author Poet
 * @date 2020/5/20
 */
public class Offer_03_FindRepeatNumber {

    private static int[] freq;

    public static int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("param is not valid");
        }

        freq = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (freq[curr] > 0) {
                return curr;
            } else {
                freq[curr]++;
            }
        }

        throw new IllegalArgumentException("no solution.");
    }



    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(arr));
    }
}
