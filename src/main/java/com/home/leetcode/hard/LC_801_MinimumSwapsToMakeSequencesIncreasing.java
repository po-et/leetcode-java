package com.home.leetcode.hard;

/**
 * 801. Minimum Swaps To Make Sequences Increasing
 *
 * You are given two integer arrays of the same length nums1 and nums2.
 * In one operation, you are allowed to swap nums1[i] with nums2[i].
 *
 * For example, if nums1 = [1,2,3,8], and nums2 = [5,6,7,4], you can swap the element at i = 3 to obtain nums1 = [1,2,3,4] and nums2 = [5,6,7,8].
 * Return the minimum number of needed operations to make nums1 and nums2 strictly increasing.
 *
 * The test cases are generated so that the given input always makes it possible.
 *
 * An array arr is strictly increasing if and only if arr[0] < arr[1] < arr[2] < ... < arr[arr.length - 1].
 *
 * Example 1:
 * Input: nums1 = [1,3,5,4], nums2 = [1,2,3,7]
 * Output: 1
 * Explanation:
 * Swap nums1[3] and nums2[3]. Then the sequences are:
 * nums1 = [1, 3, 5, 7] and nums2 = [1, 2, 3, 4]
 * which are both strictly increasing.
 *
 * Example 2:
 * Input: nums1 = [0,3,5,8,9], nums2 = [2,1,4,6,9]
 * Output: 1
 *
 * @see <a href="https://leetcode.cn/problems/minimum-swaps-to-make-sequences-increasing/" />
 * @author Poet
 * @date 2022/10/10
 */
public class LC_801_MinimumSwapsToMakeSequencesIncreasing {

    /**
     * 方法一：动态规划
     *
     * 状态定义：
     *      可以简单的定义为f[i][j] (i为字符串前i个字符，j为0,1表示第i位是否交换)
     *
     * 初始条件：
     *      f[0][0] = 0;
     *      f[0][1] = 1;
     *
     * 转移方程：
     *      f[i][0] = min(f[i - 1][0], f[i - 1][1]);
     *      f[i][1] = min(f[i - 1][0] + 1, f[i - 1][1] + 1);
     *
     * 结果为
     *      min(f[n - 1][0], f[n - 1][1]);
     *
     * solution：
     *  - https://leetcode.cn/problems/minimum-swaps-to-make-sequences-increasing/solution/by-mumuxinfei-o24a/
     *  - https://leetcode.cn/problems/minimum-swaps-to-make-sequences-increasing/solution/dong-tai-gui-hua-de-yi-ban-bu-zou-by-li-zhi-chao-4/
     */
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = 1;

        for (int i = 1; i < n; i++) {
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {   //任意交换或者不交换，取最优值
                    dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]);
                    dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;
                } else {
                    dp[i][0] = dp[i - 1][0];            // 不交换，则上个位置也不能交换
                    dp[i][1] = dp[i - 1][1] + 1;        // 交换，则上个位置也必须交换
                }
            } else {
                dp[i][0] = dp[i - 1][1];        // 不交换，则上个位置必须交换
                dp[i][1] = dp[i - 1][0] + 1;    // 交换，则上个位置不能交换
            }
        }

        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }
}
