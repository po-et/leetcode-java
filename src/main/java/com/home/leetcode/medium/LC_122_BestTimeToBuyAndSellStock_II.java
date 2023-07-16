package com.home.leetcode.medium;

/**
 * 122. Best Time to Buy and Sell Stock II （买卖股票的最佳时机 II）
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 * @see <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii" />
 * @author Poet
 * @date 2020/5/23
 */
public class LC_122_BestTimeToBuyAndSellStock_II {

    /**
     * 方法一：动态规划
     *
     * 状态定义：
     *   状态 dp[i][0] 表示第 i 天交易完后手里没有股票的最大利润， dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润（i 从 0 开始）
     *
     *
     * 官方题解：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode-s/
     */
    public int maxProfit_dp(int[] prices){
        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    public int maxProfit_dp_space_o1(int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < n; ++i) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }




    /*--------- 下面已废弃 -----------*/


    // 滑动窗口
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int l = 0, r = l + 1;
        int res = 0;

        while (r < prices.length) {
            if (prices[r - 1] <= prices[r]) {
                res += prices[r] - prices[r - 1];
                r++;
            } else {   // prices[r-1] > prices[r]
                l = r;
                r++;
            }
        }
        return res;
    }


    /**
     * 贪心算法：只要第二天的价格比今天高，就第一天买，第二天卖
     */
    public int maxProfit__2(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if(prices[i+1] - prices[i] > 0){
                max += prices[i + 1] - prices[i];
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));

        int[] arr1 = {1,2,3,4,5};
        System.out.println(maxProfit(arr1));
    }
}
