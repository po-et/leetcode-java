package com.home.leetcode;

import java.util.Arrays;

/**
 * 31. Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place, do not allocate extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1

 【题目】
     给定一个数据排列，要求找出该组数据组成的下一个比原排列大的数据，如果这样的数据不存在（原排列已经是最大组合），则将数据按升序排列（最小组合），说得更直白一点：给你三个数1,2,3,这三个数能够构成的最小数为123，最大为321，给定其中一种组合如132，要求下一个比它大的组合，必须是下一个，显然这个数为：213.

 【分析】
     这个题目本身不难，关键是理解题意，我们以一个例子来分析，给定325421，求其下一个比它大的数，怎么办呢？我们应该从最低位开始，1->2->4->5,这一段是升序的，也就是5421已经是最大数，不存在比它大的组合，我们继续找，1->2->4->5->2，出现降序这个位置就是我们要找的关键点，只需要将2与其后的数字中的（1,2,4,5）比它大的最小数，也就4替换，然后再将后面的数（1,2,2,5）升序排列便可得到下一个数，过程为：325421->345221->345122

 * Created by Poet on 2019-01-13.
 */
public class NextPermutation_31 {

    /**
     * time: O(n)
     * space: O(1)

     eg:
      // 1   2   7   4   3   1
             ^
      // 1   2   7   4   3   1
                         ^
      // 1   3   7   4   2   1
                         ^
      // 1   3   7   4   2   1
                 ^   ^   ^   ^  (最后几位反转）
      // 1   3   1   2   4   7
     */
    public static void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int firstSmall = -1;
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstSmall = i;
                break;
            }
        }
        if (firstSmall == -1) {
            reverse(nums, 0, nums.length - 1);
        }

        int firstLarge = -1;
        for (int i = nums.length-1; i > firstSmall; i--) {
            if (nums[i] > nums[firstSmall]) {
                firstLarge = i;
                break;
            }
        }

        swap(nums, firstSmall, firstLarge);
        reverse(nums, firstSmall+1, nums.length-1);
        return;
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 4, 3, 1};
        System.out.println(Arrays.toString(nums));
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

}
