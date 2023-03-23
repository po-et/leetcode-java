package com.home.leetcode.medium;

import java.util.*;
/**
 * 1630. Arithmetic Subarrays （等差子数组）
 *
 * A sequence of numbers is called arithmetic if it consists of at least two elements, and the difference between every two consecutive elements is the same. More formally, a sequence s is arithmetic if and only if s[i+1] - s[i] == s[1] - s[0] for all valid i.
 *
 * For example, these are arithmetic sequences:
 *
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * The following sequence is not arithmetic:
 *
 * 1, 1, 2, 5, 7
 * You are given an array of n integers, nums, and two arrays of m integers each, l and r, representing the m range queries, where the ith query is the range [l[i], r[i]]. All the arrays are 0-indexed.
 *
 * Return a list of boolean elements answer, where answer[i] is true if the subarray nums[l[i]], nums[l[i]+1], ... , nums[r[i]] can be rearranged to form an arithmetic sequence, and false otherwise.
 *
 * Example 1:
 * Input: nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
 * Output: [true,false,true]
 * Explanation:
 * In the 0th query, the subarray is [4,6,5]. This can be rearranged as [6,5,4], which is an arithmetic sequence.
 * In the 1st query, the subarray is [4,6,5,9]. This cannot be rearranged as an arithmetic sequence.
 * In the 2nd query, the subarray is [5,9,3,7]. This can be rearranged as [3,5,7,9], which is an arithmetic sequence.
 *
 * Example 2:
 * Input: nums = [-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10], l = [0,1,6,4,8,7], r = [4,4,9,7,9,10]
 * Output: [false,true,false,false,true,true]
 *
 * @see <a href="https://leetcode.cn/problems/arithmetic-subarrays/ />
 * @author Poet
 * @date 2023/3/23
 */
public class LC_1630_ArithmeticSubarrays {

    /**
     * 拷贝数组，排序，判断是不是等差数列（自己ac）
     */
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = nums.length;
        int[] data;
        List<Boolean> res = new ArrayList<>();

        for (int i = 0; i < l.length; i++) {
            int start = l[i];
            int end = r[i];
            data = new int[r[i] - l[i] + 1];
            for (int j = start; j <= end; j++) {
                data[j - start] = nums[j];
            }

            if (isArithmeticSubarray(data)) {
                res.add( true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

    private boolean isArithmeticSubarray(int[] data) {
        Arrays.sort(data);
        if (data.length <= 1) {
            return true;
        }
        int difference = data[1] - data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] - data[i - 1] != difference) {
                return false;
            }
        }
        return true;
    }



    /**
     * 方法一：多次遍历 + 枚举（官方题解）
     */
    public List<Boolean> checkArithmeticSubarrays_official(int[] nums, int[] l, int[] r) {
        int n = l.length;
        List<Boolean> ans = new ArrayList<Boolean>();
        for (int i = 0; i < n; ++i) {
            int left = l[i], right = r[i];
            int minv = nums[left], maxv = nums[left];
            for (int j = left + 1; j <= right; ++j) {
                minv = Math.min(minv, nums[j]);
                maxv = Math.max(maxv, nums[j]);
            }

            if (minv == maxv) {
                ans.add(true);
                continue;
            }
            if ((maxv - minv) % (right - left) != 0) {
                ans.add(false);
                continue;
            }

            int d = (maxv - minv) / (right - left);
            boolean flag = true;
            boolean[] seen = new boolean[right - left + 1];
            for (int j = left; j <= right; ++j) {
                if ((nums[j] - minv) % d != 0) {
                    flag = false;
                    break;
                }
                int t = (nums[j] - minv) / d;
                if (seen[t]) {
                    flag = false;
                    break;
                }
                seen[t] = true;
            }
            ans.add(flag);
        }
        return ans;
    }
}
