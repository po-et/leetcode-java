package com.home.leetcode.medium;

/**
 * 565. Array Nesting (数组嵌套)
 *
 * You are given an integer array nums of length n where nums is a permutation of the numbers in the range [0, n - 1].
 *
 * You should build a set s[k] = {nums[k], nums[nums[k]], nums[nums[nums[k]]], ... } subjected to the following rule:
 *      The first element in s[k] starts with the selection of the element nums[k] of index = k.
 *      The next element in s[k] should be nums[nums[k]], and then nums[nums[nums[k]]], and so on.
 *      We stop adding right before a duplicate element occurs in s[k].
 * Return the longest length of a set s[k].
 *
 * Example 1:
 * Input: nums = [5,4,0,3,1,6,2]
 * Output: 4
 * Explanation:
 * nums[0] = 5, nums[1] = 4, nums[2] = 0, nums[3] = 3, nums[4] = 1, nums[5] = 6, nums[6] = 2.
 * One of the longest sets s[k]:
 * s[0] = {nums[0], nums[5], nums[6], nums[2]} = {5, 6, 2, 0}
 *
 * Example 2:
 * Input: nums = [0,1,2]
 * Output: 1
 *
 * @see <a href="https://leetcode.cn/problems/array-nesting/" />
 * @author Poet
 * @date 2022/7/17
 */
public class LC_565_ArrayNesting {

    /**
     * 方法一：图
     *
     * 遍历数组，从 i 向 nums[i] 连边，我们可以得到一张有向图。
     * 由于题目保证 nums 中不含有重复的元素，因此有向图中每个点的出度和入度均为 1。
     * 在这种情况下，有向图必然由一个或多个环组成。我们可以遍历 nums，找到节点个数最大的环。
     *
     * time:  O(n)
     * space: O(n)
     */
    public int arrayNesting(int[] nums) {
        int res = 0;
        int n = nums.length;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            while (!visited[i]) {
                visited[i] = true;
                i = nums[i];
                cnt ++;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}
