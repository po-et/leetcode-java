package com.home.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 面试题 16.19. Pond Sizes LCCI
 *
 * You have an integer matrix representing a plot of land, where the value at that location represents the height above sea level.
 * A value of zero indicates water. A pond is a region of water connected vertically, horizontally, or diagonally.
 * The size of the pond is the total number of connected water cells.
 *
 * Write a method to compute the sizes of all ponds in the matrix.
 *
 * Example:
 * Input:
 * [
 *   [0,2,1,0],
 *   [0,1,0,1],
 *   [1,1,0,1],
 *   [0,1,0,1]
 * ]
 * Output:  [1,2,4]
 *
 * @see <a href="https://leetcode.cn/problems/pond-sizes-lcci/" />
 * @author Poet
 * @date 2023/6/22
 */
public class LCCI_16_19_PondSizes {

    /**
     * 方法一：深度优先搜索
     */
    private int m, n;
    private boolean[][] visited;

    public int[] pondSizes(int[][] land) {
        m = land.length;
        n = land[0].length;
        visited = new boolean[m][n];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0) {
                    res.add(dfs(land, i, j));
                }
            }
        }

        Collections.sort(res);
        return res.stream().mapToInt(i -> i).toArray();
    }

    private int dfs(int[][] land, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || land[x][y] != 0) {
            return 0;
        }

        visited[x][y] = true;
        int res = 1;
        // 对相邻的8个相邻节点进行DFS
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) {
                    continue;
                }
                res += dfs(land, x + dx, y + dy);
            }
        }
        return res;
    }

}
