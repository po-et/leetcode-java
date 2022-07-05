package com.home.jianzhi_offer;

/**
 * 面试题49. 丑数
 *
 * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 *
 * @see <a href="https://leetcode.cn/problems/chou-shu-lcof/" />
 * @author Poet
 * @date 2020/6/1
 */
public class Offer_49_UglyNumber_II {

    /**
     * 动态规划
     *
     * 状态定义：设动态规划列表dp ，dp[i]代表第 i + 1个丑数。
     * 转移方程：dp[i] = min(dp[a]×2, dp[b]×3, dp[c]×5)
     *
     * solution: https://leetcode.cn/problems/chou-shu-lcof/solution/mian-shi-ti-49-chou-shu-dong-tai-gui-hua-qing-xi-t/
     */
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;  // 初始状态： dp[0] = 1，即第一个丑数为1

        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);

            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n - 1];
    }
}
