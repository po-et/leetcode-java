package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum Ⅱ
 *
 Given a collection of candidate numbers (candidates) and a target number (target),
 find all unique combinations in candidates where the candidate numbers sums to target.

 Example 1:
     Input: candidates = [10,1,2,7,6,1,5], target = 8,
     A solution set is:
     [
         [1, 7],
         [1, 2, 5],
         [2, 6],
         [1, 1, 6]
     ]

 Note:
 1. All numbers (including target) will be positive integers.
 2. The solution set must not contain duplicate combinations.

 * @see <a href="https://leetcode.cn/problems/combination-sum-ii/" />
 * @author Poet
 * @date 2019/1/17
 */
public class LC_040_CombinationSum_II {

    /**
     * backtracking
     *
     * time:  O(2^n)
     * space: O(n)
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);
        helper(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            helper(res, list, candidates, target - candidates[i], i + 1);
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] array = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(array, target));
    }

}
