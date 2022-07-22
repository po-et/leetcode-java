package com.home.leetcode.easy;

/**
 * 121. 买卖股票的最佳时机
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * @see <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock" />
 * @author Poet
 * @date 2020/5/23
 */
public class LC_121_BestTimeToBuyAndSellStock {

    // 同 {@link Offer_63_BestTimeToBuyAndSellStock}
    /**
     * 方法二：动态规划
     *
     * 状态定义：
     *   设动态规划列表 dp ，dp[i] 代表以 prices[i] 为结尾的子数组的最大利润（以下简称为 前 i 日的最大利润 ）。
     *
     * 状态转移方程：
     *   由于题目限定 “买卖该股票一次” ，因此前 i 日最大利润 dp[i] 等于前 i - 1 日最大利润 dp[i-1] 和第 i 日卖出的最大利润中的最大值。
     *   前i日最大利润 = max( 前(i−1)日最大利润, 第i日价格 − 前i日最低价格 )
     *      dp[i]    = max( dp[i−1], prices[i] − min(prices[0:i]) )
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


    public static void main(String[] args) {
        LC_121_BestTimeToBuyAndSellStock solution = new LC_121_BestTimeToBuyAndSellStock();
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit_dp(arr));

        int[] arr1 = {7, 6, 4, 3, 1};
        System.out.println(solution.maxProfit_dp(arr1));
    }
}
