package com.home.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. Permutations II

 Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 Example:
     Input: [1,1,2]
     Output:
         [
             [1,1,2],
             [1,2,1],
             [2,1,1]
         ]

 * @leetcode: https://leetcode.com/problems/permutations-ii/
 * Created by Poet on 2019-01-21.
 */
public class PermutationsII_47 {

    /**
     * backtracking方法（更推荐）
     * time: O(n!)
     * space: O(n)
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            list.add(nums[i]);
            helper(res, list, nums, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }


    /**
     * 第二种方法：swap的方法
     * time: O(n!)
     * space: O(n)
     */
    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        helper2(res, 0, nums);
        return res;
    }

    private void helper2(List<List<Integer>> res, int start, int[] nums) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(new ArrayList<>(list));
            return ;
        }
        for (int i = start; i < nums.length; i++) {
            if (isUsed(nums, start, i)) continue;
            swap(nums, start, i);
            helper2(res, start + 1, nums);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    private boolean isUsed(int[] nums, int i, int j) {
        for (int x = i; x < j; x++) {
            if(nums[x] == nums[j]) return true;
        }
        return false;
    }

}
