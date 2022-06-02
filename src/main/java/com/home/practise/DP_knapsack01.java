package com.home.practise;

import java.util.List;

/**
 * 0-1背包问题
 *
 *
 * @see https://coding.imooc.com/class/chapter/82.html
 *      重点看liuyubo的题解：9-5  0-1背包问题
 * @author Poet
 * @date 2022/6/2
 */
public class DP_knapsack01 {

    /**
     * 状态的定义：
     *     F(n, C) 考虑将n个物品放进容量为C的背包，使得价值最大
     *
     * 状态的转移：
     *     F(i, c) = F(i-1, c)                // 不放入第i个物品
     *             = v(i) + F(i-1, c-w(i))    // 放入第i个物品     ===> MAX
     *
     *     所以，
     *     F(i, c) = max( F(i-1, c), v(i) + F(i-1, c-w(i) )
     */


    private int[][] memo;

    // 递归：记忆化搜索
    public int knapsack01(List<Integer> weights, List<Integer> values, int C) {
        int n = weights.size();
        memo = new int[n][C];
        return bestValue(weights, values, n - 1, C);
    }

    // 用 [0...index] 的物品，填充容量为c的背包的最大价值
    private int bestValue(List<Integer> w, List<Integer> v, int index, int c) {
        if (index < 0 || c <= 0) {
            return 0;
        }

        if (memo[index][c] != 0) {
            return memo[index][c];
        }

        int res = bestValue(w, v, index - 1, c);    // 不放入第i个物品
        if (c >= w.get(index)) {
            res = Math.max(res, v.get(index) + bestValue(w, v, index - 1, c - w.get(index)));
        }
        memo[index][c] = res;
        return res;
    }


    // 动态规划
    public int knapsack01_DP(List<Integer> weights, List<Integer> values, int C) {
        int n = weights.size();
        if (n == 0) {
            return 0;
        }

        int[][] memo = new int[n][C];

        // 先解决最基础的问题
        for (int i = 0; i <= C; i++) {
            memo[0][i] = i >= weights.get(0) ? values.get(0) : 0;
        }

        // 然后开始递推
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                memo[i][j] = memo[i - 1][j];
                if (j >= weights.get(i)) {
                    memo[i][j] = Math.max(memo[i][j], values.get(i) + memo[i - 1][j - weights.get(i)]);
                }
            }
        }

        return memo[n - 1][C];
    }

}
