package com.home.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找出数组中所有3个和为0的组合，不能重复
 *
 * for example:
 *  S = [-1, 0, 1, 2, -1, -4, 4, -2]
 * Created by Poet on 2019-01-10.
 */
public class ThreeSum_15 {

    /**
     * time: O(n^2)
     * space: O(n)
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        //nums.length-2 是因为左右都有指针，而且3元素相加
        for (int i = 0; i < nums.length-2; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;   //避免重复

            int low = i + 1, high = nums.length - 1, sum = 0 - nums[i];
            while (low < high) {
                if (nums[low] + nums[high] == sum) {
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while(low<high && nums[low] == nums[low+1]) low++;       //避免重复
                    while(low<high && nums[high] == nums[high-1]) high--;    //避免重复
                    low++;
                    high--;
                } else if (nums[low] + nums[high] < sum) {
                    low++;
                } else high--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, -2, 1, 2, -1, -4, 4, -2};
        List<List<Integer>> list = threeSum(arr);
        list.forEach(n->System.out.println(n));
    }

}
