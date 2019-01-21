package com.home.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 *
 * 时间复杂度参考： https://www.1point3acres.com/bbs/thread-117602-1-1.html
 * Created by Poet on 2019-01-21.
 */
public class Permutations_46 {

    /**
     * 很简单的一个backtracking
     * time: O(n! * n)
     * space: O(n)
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums ==null || nums.length == 0) return res;
        helper(res, new ArrayList<>(), nums);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            helper(res, list, nums);
            list.remove(list.size() - 1);
        }
    }

}
