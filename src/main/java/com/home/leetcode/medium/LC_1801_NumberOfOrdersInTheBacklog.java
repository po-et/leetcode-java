package com.home.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1801. Number of Orders in the Backlog
 *
 * You are given a 2D integer array orders, where each orders[i] = [pricei, amounti, orderTypei] denotes that amounti orders have been placed of type orderTypei at the price pricei.
 *
 * The orderTypei is:
 *  - 0 if it is a batch of buy orders, or
 *  - 1 if it is a batch of sell orders.
 *
 * Note that orders[i] represents a batch of amounti independent orders with the same price and order type. All orders represented by orders[i] will be placed before all orders represented by orders[i+1] for all valid i.
 *
 * There is a backlog that consists of orders that have not been executed. The backlog is initially empty. When an order is placed, the following happens:
 *
 * If the order is a buy order, you look at the sell order with the smallest price in the backlog. If that sell order's price is smaller than or equal to the current buy order's price, they will match and be executed, and that sell order will be removed from the backlog. Else, the buy order is added to the backlog.
 * Vice versa, if the order is a sell order, you look at the buy order with the largest price in the backlog. If that buy order's price is larger than or equal to the current sell order's price, they will match and be executed, and that buy order will be removed from the backlog. Else, the sell order is added to the backlog.
 * Return the total amount of orders in the backlog after placing all the orders from the input. Since this number can be large, return it modulo 109 + 7.
 *
 * Example 1:
 * Input: orders = [[10,5,0],[15,2,1],[25,1,1],[30,4,0]]
 * Output: 6
 *
 * Example 2:
 * Input: orders = [[7,1000000000,1],[15,3,0],[5,999999995,0],[5,1,1]]
 * Output: 999999984
 *
 * @see <a href="https://leetcode.cn/problems/number-of-orders-in-the-backlog/" />
 * @author Poet
 * @date 2023/1/2
 */
public class LC_1801_NumberOfOrdersInTheBacklog {

    // 参考答案

    /**
     * 方法一：优先队列模拟
     *
     * 寻找已有的积压订单时，需要寻找【价格最高的采购订单】或者【价格最低的销售订单】，因此可以使用两个优先队列分别存储积压的采购订单和积压的销售订单，
     * 两个优先队列称为采购订单优先队列和销售订单优先队列，分别满足队首元素是价格最高的采购订单和价格最低的销售订单
     */
    public int getNumberOfBacklogOrders(int[][] orders) {
        final int MOD = 1000000007;
        PriorityQueue<int[]> buyOrders = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> sellOrders = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int[] order : orders) {
            int price = order[0], amount = order[1], orderType = order[2];
            if (orderType == 0) {   // buy
                while (amount > 0 && !sellOrders.isEmpty() && sellOrders.peek()[0] <= price) {
                    int[] sellOrder = sellOrders.poll();
                    int sellAmount = Math.min(amount, sellOrder[1]);
                    amount -= sellAmount;
                    sellOrder[1] -= sellAmount;
                    if (sellOrder[1] > 0) {
                        sellOrders.offer(sellOrder);
                    }
                }
                if (amount > 0) {
                    buyOrders.offer(new int[]{price, amount});
                }
            } else {    // sell
                while (amount > 0 && !buyOrders.isEmpty() && buyOrders.peek()[0] >= price) {
                    int[] buyOrder = buyOrders.poll();
                    int buyAmount = Math.min(amount, buyOrder[1]);
                    amount -= buyAmount;
                    buyOrder[1] -= buyAmount;
                    if (buyOrder[1] > 0) {
                        buyOrders.offer(buyOrder);
                    }
                }
                if (amount > 0) {
                    sellOrders.offer(new int[]{price, amount});
                }
            }
        }

        int total = 0;
        for (PriorityQueue<int[]> pq : Arrays.asList(buyOrders, sellOrders)) {
            while (!pq.isEmpty()) {
                int[] order = pq.poll();
                total = (total + order[1]) % MOD;
            }
        }
        return total;
    }
}
