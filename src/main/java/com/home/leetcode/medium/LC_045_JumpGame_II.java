package com.home.leetcode.medium;

/**
 * 45. Jump Game II （跳跃游戏 II）
 *
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * You can assume that you can always reach the last index.
 *
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 * @see <a href="https://leetcode.cn/problems/jump-game-ii/" />
 * Created by Poet on 2019-01-20.
 */
public class LC_045_JumpGame_II {

    /**
     * 方法一：反向查找出发位置
     *
     * time:  O(n^2) 其中 n 是数组长度。有两层嵌套循环，在最坏的情况下，例如数组中的所有元素都是 1，position 需要遍历数组中的每个位置，对于 position 的每个值都有一次循环。
     * space: O(1)
     */
    public int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;

        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }


    /**
     * 方法二：正向查找可到达的最大位置
     *
     * time:  O(n)
     * space: O(1)
     */
    public int jump_space_o1(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;

        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }






//    /**
//     * Greedy的思想
//     * time: O(n)
//     * space: O(1)
//     */
//    public int jump1(int[] nums) {
//        if(nums == null || nums.length<2) return 0;
//        int res = 0;
//        int curMaxArea = 0;     //当前能走到的最大距离
//        int maxNext = 0;        //能走到的最大距离
//        for (int i = 0; i < nums.length - 1; i++) {
//            maxNext = Math.max(maxNext, i + nums[i]);
//            if (i == curMaxArea) {
//                res++;
//                curMaxArea = maxNext;
//            }
//        }
//        return res;
//    }
//
//    /**
//     * BFS的方法
//     * time: O(n)
//     * space: O(1)
//     */
//    public int jump2(int[] nums) {
//        if(nums == null || nums.length<2) return 0;
//        int level = 0;
//        int curMaxArea = 0;
//        int maxNext = 0;
//        int i = 0;
//        while (curMaxArea - i + 1 > 0) {
//            level++;
//            for (; i <= curMaxArea; i++) {
//                maxNext = Math.max(maxNext, nums[i] + i);
//                if (maxNext > nums.length - 1) {
//                    return level;
//                }
//            }
//            curMaxArea = maxNext;
//        }
//        return 0;
//    }
}
