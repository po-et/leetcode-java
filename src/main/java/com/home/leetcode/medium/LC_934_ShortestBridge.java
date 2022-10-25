package com.home.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 934. Shortest Bridge （最短的桥）
 *
 * You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
 *
 * An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.
 *
 * You may change 0's to 1's to connect the two islands to form one island.
 *
 * Return the smallest number of 0's you must flip to connect the two islands.
 *
 * Example 1:
 * Input: grid = [[0,1],[1,0]]
 * Output: 1
 *
 * Example 2:
 * Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 *
 * Example 3:
 * Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 *
 * @see <a href="https://leetcode.cn/problems/shortest-bridge/" />
 * @author Poet
 * @date 2022/10/25
 */
public class LC_934_ShortestBridge {

    // 参考答案，再思考一遍

    /* --- 这道题来自：第 109 场周赛 --- */
    /**
     * 方法一：广度优先搜索
     *
     * 题目中求最少的翻转 0 的数目等价于求矩阵中两个岛的最短距离，因此我们可以广度优先搜索来找到矩阵中两个块的最短距离。
     *
     */
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        List<int[]> island = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    grid[i][j] = -1;
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int x = cell[0], y = cell[1];
                        island.add(cell);
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dirs[k][0];
                            int ny = y + dirs[k][1];
                            if (nx >= 0 && ny >= 0 && nx < n && ny < n && grid[nx][ny] == 1) {
                                queue.offer(new int[]{nx, ny});
                                grid[nx][ny] = -1;
                            }
                        }
                    }
                    for (int[] cell : island) {
                        queue.offer(cell);
                    }
                    int step = 0;
                    while (!queue.isEmpty()) {
                        int sz = queue.size();
                        for (int k = 0; k < sz; k++) {
                            int[] cell = queue.poll();
                            int x = cell[0], y = cell[1];
                            for (int d = 0; d < 4; d++) {
                                int nx = x + dirs[d][0];
                                int ny = y + dirs[d][1];
                                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                                    if (grid[nx][ny] == 0) {
                                        queue.offer(new int[]{nx, ny});
                                        grid[nx][ny] = -1;
                                    } else if (grid[nx][ny] == 1) {
                                        return step;
                                    }
                                }
                            }
                        }
                        step++;
                    }
                }
            }
        }
        return 0;
    }

}
