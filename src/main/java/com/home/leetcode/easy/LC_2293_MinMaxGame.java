package com.home.leetcode.easy;

/**
 * 2293. Min Max Game (极大极小游戏)
 *
 * You are given a 0-indexed integer array nums whose length is a power of 2.
 *
 * Apply the following algorithm on nums:
 *
 *  - Let n be the length of nums. If n == 1, end the process. Otherwise, create a new 0-indexed integer array newNums of length n / 2.
 *  - For every even index i where 0 <= i < n / 2, assign the value of newNums[i] as min(nums[2 * i], nums[2 * i + 1]).
 *  - For every odd index i where 0 <= i < n / 2, assign the value of newNums[i] as max(nums[2 * i], nums[2 * i + 1]).
 *  - Replace the array nums with newNums.
 *  - Repeat the entire process starting from step 1.
 *
 * Return the last number that remains in nums after applying the algorithm.
 *
 * Example 1:
 * Input: nums = [1,3,5,2,4,8,2,2]
 * Output: 1
 * Explanation: The following arrays are the results of applying the algorithm repeatedly.
 * First: nums = [1,5,4,2]
 * Second: nums = [1,4]
 * Third: nums = [1]
 * 1 is the last remaining number, so we return 1.
 *
 * Example 2:
 * Input: nums = [3]
 * Output: 3
 * Explanation: 3 is already the last remaining number, so we return 3.
 *
 * @see <a href="https://leetcode.cn/problems/min-max-game/" />
 * @author Poet
 * @date 2023/1/15
 */
public class LC_2293_MinMaxGame {

    /**
     * 模拟 （自己ac）
     *
     * time:  O(n)
     * space: O(1) 原地修改
     */
    public int minMaxGame(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }

        int n = nums.length;

        while (n > 1) {
            int index = 0;
            for (int i = 0; i < n; i = i + 2) {
                if (index % 2 == 0) {
                    nums[index] = Math.min(nums[i], nums[i + 1]);
                } else {
                    nums[index] = Math.max(nums[i], nums[i + 1]);
                }
                index++;
            }
            n = n / 2;
        }

        return nums[0];
    }

    /**
     * 方法一：递归
     *
     * time:  O(n)
     * space: O(n)
     */
    public int minMaxGame_1(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int[] newNums = new int[n / 2];
        for (int i = 0; i < newNums.length; i++) {
            if (i % 2 == 0) {
                newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            } else {
                newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            }
        }

        return minMaxGame_1(newNums);
    }


    /**
     * 方法二：模拟
     *
     * time:  O(n)
     * space: O(n)
     */
    public int minMaxGame_2(int[] nums) {
        int n = nums.length;
        while (n != 1) {
            int[] newNums = new int[n / 2];
            for (int i = 0; i < newNums.length; i++) {
                if (i % 2 == 0) {
                    newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            nums = newNums;
            n /= 2;
        }
        return nums[0];
    }

}
