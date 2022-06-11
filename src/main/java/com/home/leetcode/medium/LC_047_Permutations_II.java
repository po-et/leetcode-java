package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. Permutations II
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *      Input: [1,1,2]
 *      Output:
 *          [
 *              [1,1,2],
 *              [1,2,1],
 *              [2,1,1]
 *          ]
 *
 * @see <a href="https://leetcode.com/problems/permutations-ii/" />
 * @author Poet
 * @date 2019-01-21
 */
public class LC_047_Permutations_II {

    List<List<Integer>> res;
    boolean[] visited;

    /**
     * 回溯法
     * @see <a href="https://leetcode.cn/problems/permutations-ii/solution/quan-pai-lie-ii-by-leetcode-solution/" />
     *
     * time: O(n×n!)
     * space: O(n)
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }

        List<Integer> perm = new ArrayList<>();
        visited = new boolean[nums.length];

        // 排序保证重复数字都在相邻的位置
        Arrays.sort(nums);

        backtrack(nums, 0, perm);
        return res;
    }

    private void backtrack(int[] nums, int index, List<Integer> perm) {
        if (index == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 保证在填第index个数的时候重复数字只会被填入一次
            // 对原数组排序，保证相同的数字都相邻，然后每次填入的数一定是这个数所在重复数集合中「从左往右第一个未被填过的数字」
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }

            perm.add(nums[i]);
            visited[i] = true;
            backtrack(nums, index + 1, perm);
            visited[i] = false;
            perm.remove(perm.size() - 1);
        }
    }

}
