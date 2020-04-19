package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * @see <a href = "https://leetcode.com/problems/4sum/" />
 * @author Poet
 * @date 2020/4/19
 */
public class FourSum_18 {

    public static void main(String[] args) {
        FourSum_18 solution = new FourSum_18();

        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(solution.fourSum(nums, target));
    }

    /**
     * 模仿 ThreeSum_15思路 {@link ThreeSum_15}
     * time: O(n^3)
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (Objects.isNull(nums) || nums.length < 4) {
            return ret;
        }

        // 先排序 O(nlogn)
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            //选定nums[i]为第一个数，并去重
            if(i > 0 && nums[i] == nums[i-1]) continue;

            for (int j = i+1; j < nums.length; j++) {
                if(j > i + 1 && nums[j] == nums[j-1]) continue;

                int left = j+1, right = nums.length-1;
                while(left < right){
                    int sum = nums[i] + nums[j] +  nums[left] + nums[right] ;
                    if (sum == target) {
                        List<Integer> innerRet = new ArrayList<>();
                        innerRet.add(nums[i]);
                        innerRet.add(nums[j]);
                        innerRet.add(nums[left]);
                        innerRet.add(nums[right]);
                        ret.add(innerRet);

                        left++;
                        right--;

                        //去重
                        while(left<right && nums[left] == nums[left-1]) left++;
                        while(left<right && nums[right] == nums[right+1]) right--;

                    } else if (sum < target) {
                        left ++;
                    } else {  // sum > 0
                        right--;
                    }
                }
            }
        }

        return ret;
    }

}
