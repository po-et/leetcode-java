package com.home.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. Summary Ranges (汇总区间)
 *
 * You are given a sorted unique integer array nums.
 *
 * A range [a,b] is the set of all integers from a to b (inclusive).
 *
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
 * That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 *
 * Each range [a,b] in the list should be output as:
 *  - "a->b" if a != b
 *  - "a" if a == b
 *
 * Example 1:
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 *
 * Example 2:
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: The ranges are:
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 *
 * @see <a href="https://leetcode.cn/problems/summary-ranges/description/" />
 * @author Poet
 * @date 2023/8/26
 */
public class LC_228_SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int n = nums.length;

        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i - 1] + 1 == nums[i]) {
                i++;
            }
            int high = i - 1;
            StringBuilder builder = new StringBuilder(nums[low] + "");
            if (low < high) {
                builder.append("->").append(nums[high] + "");
            }
            res.add(builder.toString());
        }

        return res;
    }
}
