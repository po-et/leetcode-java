package com.home.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1200. Minimum Absolute Difference (最小绝对差)
 *
 * Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
 *
 * Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
 *      a, b are from arr
 *      a < b
 *      b - a equals to the minimum absolute difference of any two elements in arr
 *
 *
 * Example 1:
 *
 * Input: arr = [4,2,1,3]
 * Output: [[1,2],[2,3],[3,4]]
 * Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
 *
 * Example 2:
 * Input: arr = [1,3,6,10,15]
 * Output: [[1,3]]
 *
 * Example 3:
 * Input: arr = [3,8,-10,23,19,-4,-14,27]
 * Output: [[-14,-10],[19,23],[23,27]]
 *
 * @see <a href="https://leetcode.cn/problems/minimum-absolute-difference/" />
 * @author Poet
 * @date 2022/7/4
 */
public class LC_1200_MinimumAbsoluteDifference {

    /**
     * 方法一：排序 + 一次遍历
     *
     * 这样一来，拥有「最小绝对差」的元素对只能由有序数组中相邻的两个元素构成。
     *
     * 随后我们对数组 arr 进行一次遍历。当遍历到 arr[i] 和 arr[i+1] 时，它们的差为 δ=arr[i+1]−arr[i]。
     * 我们使用一个变量 best 存储当前遇到的最小差，以及一个数组 res 存储答案
     *
     * time:  O(nlogn) 其中 n 是数组 arr 的长度
     * space: O(logn) 即为排序需要使用的栈空间
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        int best = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(arr);

        for (int i = 0; i < n - 1; i++) {
            int delta = arr[i + 1] - arr[i];

            if (delta < best) {
                best = delta;
                res.clear();
                res.add(List.of(arr[i], arr[i + 1]));
            } else if (delta == best) {
                res.add(List.of(arr[i], arr[i + 1]));
            }
        }

        return res;
    }

}
