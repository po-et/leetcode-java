package com.home.offer.jianzhi;

/**
 * 剑指 Offer 13. 机器人的运动范围
 *
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 *
 * 示例 2：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * @see <a href="https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof" />
 * @author Poet
 * @date 2022/6/18
 */
public class Offer_13_MovingCount {

    private boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        return dfs(m, n, k, 0, 0);
    }

    private int dfs(int m, int n, int k, int startX, int startY) {
        // 递归终止条件
        if (startX < 0 || startX >= m || startY < 0 || startY >= n || visited[startX][startY]) {
            return 0;
        }
        if (bitSum(startX) + bitSum(startY) > k) {
            return 0;
        }

        visited[startX][startY] = true;
        //当前格 + 往下走 + 往右走
        return 1 + dfs(m, n, k, startX + 1, startY) + dfs(m, n, k, startX, startY + 1);
    }

    private int bitSum(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x = x / 10;
        }
        return res;
    }

}
