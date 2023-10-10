package com.home.jianzhi_offer;

/**
 * 剑指 Offer 63. 股票的最大利润
 *
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 *
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * @see <a href="https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof" />
 * @author Poet
 * @date 2022/6/12
 */
public class Offer_63_BestTimeToBuyAndSellStock {

    /**
     * 方法一：一次遍历
     * 用一个变量记录一个历史最低价格 minPrice，我们就可以假设自己的股票是在那天买的。那么我们在第 i 天卖出股票能得到的利润就是 prices[i] - minPrice。
     *
     * time:  O(n)
     * space: O(1)
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }


    /**
     * 方法二：动态规划
     *
     * 状态定义：
     *   设动态规划列表 dp ，dp[i] 代表以 prices[i] 为结尾的子数组的最大利润（以下简称为 前 i 日的最大利润 ）。
     *
     * 状态转移方程：
     *   由于题目限定 “买卖该股票一次” ，因此前 i 日最大利润 dp[i] 等于前 i - 1 日最大利润 dp[i-1] 和第 i 日卖出的最大利润中的最大值。
     *   前i日最大利润 = max( 前(i−1)日最大利润, 第i日价格−前i日最低价格 )
     *   dp[i] = max( dp[i−1], prices[i] − min(prices[0:i]) )
     *
     * 初始状态：
     *   dp[0] = 0, 即首日利润为 0
     *
     * 返回值：
     *   dp[n−1] ，其中 n 为 dp 列表长度。
     *
     * 效率优化：
     *   - 时间复杂度降低：
     *       - 借助一个变量：成本 cost
     *   - 空间复杂度降低：
     *       - 使用一个变量（记为利润 profit ）代替 dp 列表
     *
     * 题解：https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof/solution/mian-shi-ti-63-gu-piao-de-zui-da-li-run-dong-tai-2/
     */
    public int maxProfit_dp(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        int minPrice = prices[0];

        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
        }

        return dp[n - 1];
    }

    // 方法二的空间优化版，space: O(1)
    public int maxProfit_dp_space_o1(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int profit = 0;

        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }

}
