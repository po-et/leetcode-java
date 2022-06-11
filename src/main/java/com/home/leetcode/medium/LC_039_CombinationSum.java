package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 *
 Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 The same repeated number may be chosen from C unlimited number of times.

 Example 1:
 given candidate set [2, 3, 6, 7] and target 7.
 solution is [[7], [2, 2, 3]].

 注意事项
 1. All numbers (including target) will be positive integers.
 2. The solution set must not contain duplicate combinations.

 * @see <a href="https://leetcode.cn/problems/combination-sum/" />
 * Created by Poet on 2019-01-17.
 */
public class LC_039_CombinationSum {

    /**
     * 使用backtracking的方法
     *  即"回溯法": https://zh.wikipedia.org/wiki/%E5%9B%9E%E6%BA%AF%E6%B3%95
     *
     * time: O(2^n)
     * space: O(n)
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }

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
            list.add(candidates[i]);
            helper(res, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] array = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(array, target));
    }

}
