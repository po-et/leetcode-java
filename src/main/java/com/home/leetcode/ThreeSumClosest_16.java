package com.home.leetcode;

import java.util.Arrays;

/**
 * 给定target的，找出数组中3个加和最接近的
 * <p>
 * Created by Poet on 2019-01-10.
 */
public class ThreeSumClosest_16 {

    /**
     * time: O(n^2)
     * space: O(1)
     */
    public static int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);

        //nums.length-2 是因为左右都有指针，而且3元素相加
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum > target) end--;
                else start++;

                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, -2, 1, 2, -1, -4, 4, -2};
        System.out.println(threeSumClosest(arr, 8));
    }

}
