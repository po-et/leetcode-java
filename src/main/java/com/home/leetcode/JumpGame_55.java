package com.home.leetcode;

/**
 * 55. Jump Game

 Given an array of non-negative integers, you are initially positioned at the first index of the array.
 Each element in the array represents your maximum jump length at that position.
 Determine if you are able to reach the last index.

 Example 1:
     Input: [2,3,1,1,4]
     Output: true
     Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

 Example 2:
     Input: [3,2,1,0,4]
     Output: false
     Explanation: You will always arrive at index 3 no matter what. Its maximum
     jump length is 0, which makes it impossible to reach the last index.

 * @leetcode: https://leetcode.com/problems/jump-game/
 * Created by Poet on 2019-01-20.
 */
public class JumpGame_55 {

    /**
     * Greedy的思想
     * time: O(n)
     * space: O(1)
     */
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i > max) return false;
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }

}