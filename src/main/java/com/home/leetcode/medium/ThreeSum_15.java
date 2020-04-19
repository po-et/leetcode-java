package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * @see <a href = "https://leetcode.com/problems/3sum/" />
 * @author Poet
 * @date 2020/4/19
 */
public class ThreeSum_15 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        ThreeSum_15 solution = new ThreeSum_15();
        System.out.println(solution.threeSum(nums));
    }

    /**
     * time: O(n^2)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (Objects.isNull(nums) || nums.length < 3) {
            return ret;
        }

        // 先排序 O(nlogn)
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            //选定nums[i]为第一个数，并去重
            if(i>0 && nums[i] == nums[i-1]) continue;

            int left = i+1, right = nums.length-1;
            while(left<right){

                int sum = nums[i] + nums[left] + nums[right] ;
                if (sum == 0) {
                    List<Integer> innerRet = new ArrayList<>();
                    innerRet.add(nums[i]);
                    innerRet.add(nums[left]);
                    innerRet.add(nums[right]);
                    ret.add(innerRet);

                    left++;
                    right--;

                    //去重
                    while(left<right && nums[left] == nums[left-1]) left++;
                    while(left<right && nums[right] == nums[right+1]) right--;

                } else if (sum < 0) {
                    left ++;
                } else {  // sum > 0
                    right--;
                }
            }
        }

        return ret;
    }

}
