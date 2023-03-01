package com.home.leetcode.medium;

/**
 * 1144. Decrease Elements To Make Array Zigzag (递减元素使数组呈锯齿状)
 *
 * Given an array nums of integers, a move consists of choosing any element and decreasing it by 1.
 *
 * An array A is a zigzag array if either:
 *
 * Every even-indexed element is greater than adjacent elements, ie. A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * OR, every odd-indexed element is greater than adjacent elements, ie. A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * Return the minimum number of moves to transform the given array nums into a zigzag array.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: 2
 * Explanation: We can decrease 2 to 0 or 3 to 1.
 *
 * Example 2:
 * Input: nums = [9,6,1,6,2]
 * Output: 4
 *
 * @see <a href="https://leetcode.cn/problems/decrease-elements-to-make-array-zigzag/" />
 * @author Poet
 * @date 2023/2/27
 */
public class LC_1144_DecreaseElementsToMakeArrayZigzag {

    /**
     * 思路：
     * 锯齿状有两种可能性，所以分两种情况讨论：
     *  1. 将奇数位置的元素减少到刚好比相邻的偶数位置元素小（最少数量为res1）
     *  2. 将偶数位置的元素减少到刚好比相邻的奇数位置元素小（最少数量为res2）
     * 最后取奇偶分别讨论后的最小值，即Min(res1,res2)为最终答案。
     *
     * 自己写的题解：https://leetcode.cn/problems/decrease-elements-to-make-array-zigzag/solution/qi-ou-qing-kuang-fen-bie-tao-lun-javashi-27vo/
     */
    public int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        int res1 = 0, res2 = 0;
        for (int i = 0; i < n; i++) {
            if (isEven(i)) {    // 偶数
                int pre = 0, post = 0;
                if (i > 0 && nums[i] >= nums[i - 1]) {
                    pre = nums[i] - nums[i - 1] + 1;
                }
                if (i + 1 < n && nums[i] >= nums[i + 1]) {
                    post = nums[i] - nums[i + 1] + 1;
                }
                res1 += Math.max(pre, post);
            } else {            // 奇数
                int pre = 0, post = 0;
                if (i > 0 && nums[i] >= nums[i - 1]) {
                    pre = nums[i] - nums[i - 1] + 1;
                }
                if (i + 1 < n && nums[i] >= nums[i + 1]) {
                    post = nums[i] - nums[i + 1] + 1;
                }
                res2 += Math.max(pre, post);
            }
        }
        return Math.min(res1, res2);
    }

    private boolean isEven(int num) {
        return (num & 0x01) == 0;
    }
}
