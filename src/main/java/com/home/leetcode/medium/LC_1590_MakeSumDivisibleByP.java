package com.home.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1590. Make Sum Divisible by P (使数组和能被 P 整除)
 *
 * Given an array of positive integers nums, remove the smallest subarray (possibly empty) such that the sum of the remaining elements is divisible by p. It is not allowed to remove the whole array.
 *
 * Return the length of the smallest subarray that you need to remove, or -1 if it's impossible.
 *
 * A subarray is defined as a contiguous block of elements in the array.
 *
 * Example 1:
 * Input: nums = [3,1,4,2], p = 6
 * Output: 1
 * Explanation: The sum of the elements in nums is 10, which is not divisible by 6. We can remove the subarray [4], and the sum of the remaining elements is 6, which is divisible by 6.
 *
 * Example 2:
 * Input: nums = [6,3,5,2], p = 9
 * Output: 2
 * Explanation: We cannot remove a single element to get a sum divisible by 9. The best way is to remove the subarray [5,2], leaving us with [6,3] with sum 9.
 *
 * Example 3:
 * Input: nums = [1,2,3], p = 3
 * Output: 0
 * Explanation: Here the sum is 6. which is already divisible by 3. Thus we do not need to remove anything.
 *
 * @see <a href="https://leetcode.cn/problems/make-sum-divisible-by-p/" />
 * @author Poet
 * @date 2023/3/10
 */
public class LC_1590_MakeSumDivisibleByP {

    // 参考答案，不是特别理解前缀和的解法

    /**
     * 方法一：前缀和
     *
     * time:  O(n)
     * space: O(n)
     */
    public int minSubarray(int[] nums, int p) {
        int x = 0;
        for (int num : nums) {
            x = (x + num) % p;
        }
        if (x == 0) {
            return 0;
        }

        Map<Integer, Integer> index = new HashMap<>();
        int y = 0, res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            index.put(y, i);        // f[i] mod p = y，因此哈希表记录 y 对应的下标为 i
            y = (y + nums[i]) % p;
            if (index.containsKey((y - x + p) % p)) {
                res = Math.min(res, i - index.get((y - x + p) % p) + 1);
            }
        }
        return res == nums.length ? -1 : res;
    }


    @Deprecated
    public int minSubarray_wrong_answer(int[] nums, int p) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int res = n;
        for (int i = 0; i < n; i++) {
            int tmpSum = sum;
            for (int j = i; j < n; j++) {
                tmpSum = tmpSum - nums[j];
                if (tmpSum % p == 0) {
                    res = Math.min(res, j - i + 1);
                }
            }
        }
        return res == n ? -1 : res;
    }

}
