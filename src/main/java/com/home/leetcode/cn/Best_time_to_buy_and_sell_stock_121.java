package com.home.leetcode.cn;

/**
 * 121. 买卖股票的最佳时机
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
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
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * @author Poet
 * @date 2020/5/23
 */
public class Best_time_to_buy_and_sell_stock_121 {

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));

        int[] arr1 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(arr1));
    }


    // 滑动窗口
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;

        int l = 0, r = 0;
        int ret = 0;

        while (r < prices.length) {
            if (prices[l] >= prices[r]) {
                l = r;
                r++;
            } else { // prices[l] < prices[r]
                ret = Math.max(ret, prices[r] - prices[l]);
                r++;
            }
        }
        return ret;
    }





    /**
     * Wrong Answer!!!
     *
     * 输入: [2,4,1]
     * 输出 0
     * 预期结果 2
     */
    // 对撞指针
    public static int maxProfitWrong1(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;

        // 在[l..r]区间寻找最大正差值
        int l = 0, r = prices.length - 1;
        int ret = 0;

        while (l < r) {
            if (prices[l] <= prices[r]) {
                ret = Math.max(ret, prices[r] - prices[l]);
                r--;
            } else { // prices[l] >  prices[r]
                l++;
            }
        }

        return ret;
    }



    /**
     * Wrong Answer!!!
     *
     * 输入: [2,4,1]
     * 输出 0
     * 预期结果 2
     */
    // 最简单的办法：先找最小值，再寻找最小值索引之后的最大值
    public int maxProfitWrong2(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;

        int minIndex = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[minIndex]) {
                minIndex = i;
            }
        }

        int ret = 0;
        for (int i = minIndex; i < prices.length; i++) {
            ret = Math.max(ret, prices[i] - prices[minIndex]);
        }
        return ret;
    }
}
