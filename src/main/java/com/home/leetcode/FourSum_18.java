package com.home.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找出数组中4个加和为target的所有组合
 * <p>
 * Created by Poet on 2019-01-10.
 */
public class FourSum_18 {

    /**
     * time: O(n^3)
     * space: O(n)
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) return res;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;   //避免重复
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int low = j + 1, high = nums.length - 1;
                while (low < high) {
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (target == sum) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++;       //避免重复
                        while (low < high && nums[high] == nums[high - 1]) high--;    //避免重复
                        low++;
                        high--;
                    } else if (sum<target) {
                        low++;
                    } else high--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, -2, 1, 2, -1, -4, 4, -2};
        fourSum(arr, 0).forEach(System.out::println);
    }

}
