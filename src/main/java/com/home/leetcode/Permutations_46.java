package com.home.leetcode;

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
        if(nums == null || nums.length == 0) return res;
        helper(res, new ArrayList<>(), nums);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])) continue;    // O(n)
            list.add(nums[i]);
            helper(res, list, nums);
            list.remove(list.size() - 1);
        }
    }


    /**
     * 第二种方法： 规避掉list.contains(nums[i])而增加的O(n)的时间复杂度
     * time: O(n!)
     * space: O(n)
     */
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
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
            swap(nums, start, i);
            helper2(res, start+1, nums);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }


}
