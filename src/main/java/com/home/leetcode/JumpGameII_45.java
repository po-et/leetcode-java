package com.home.leetcode;

/**
 * 45. Jump Game II

 Given an array of non-negative integers, you are initially positioned at the first index of the array.
 Each element in the array represents your maximum jump length at that position.
 Your goal is to reach the last index in the minimum number of jumps.

 Example:
     Input: [2,3,1,1,4]
     Output: 2
     Explanation: The minimum number of jumps to reach the last index is 2.
                  Jump 1 step from index 0 to 1, then 3 steps to the last index.

 * Created by Poet on 2019-01-20.
 */
public class JumpGameII_45 {

    /**
     * Greedy的思想
     * time: O(n)
     * space: O(1)
     */
    public int jump1(int[] nums) {
        if(nums == null || nums.length<2) return 0;
        int res = 0;
        int curMaxArea = 0;     //当前能走到的最大距离
        int maxNext = 0;        //能走到的最大距离
        for (int i = 0; i < nums.length - 1; i++) {
            maxNext = Math.max(maxNext, i + nums[i]);
            if (i == curMaxArea) {
                res++;
                curMaxArea = maxNext;
            }
        }
        return res;
    }

    /**
     * BFS的方法
     * time: O(n)
     * space: O(1)
     */
    public int jump2(int[] nums) {
        if(nums == null || nums.length<2) return 0;
        int level = 0;
        int curMaxArea = 0;
        int maxNext = 0;
        int i = 0;
        while (curMaxArea - i + 1 > 0) {
            level++;
            for (; i <= curMaxArea; i++) {
                maxNext = Math.max(maxNext, nums[i] + i);
                if (maxNext > nums.length - 1) {
                    return level;
                }
            }
            curMaxArea = maxNext;
        }
        return 0;
    }
}
