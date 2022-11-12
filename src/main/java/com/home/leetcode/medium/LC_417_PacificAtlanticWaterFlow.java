package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 417. Pacific Atlantic Water Flow (太平洋大西洋水流问题)
 *
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 *
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 *
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
 *
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 *
 *
 * Example 1:
 * Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
 * [0,4]: [0,4] -> Pacific Ocean
 *        [0,4] -> Atlantic Ocean
 * [1,3]: [1,3] -> [0,3] -> Pacific Ocean
 *        [1,3] -> [1,4] -> Atlantic Ocean
 * [1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean
 *        [1,4] -> Atlantic Ocean
 * [2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean
 *        [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
 * [3,0]: [3,0] -> Pacific Ocean
 *        [3,0] -> [4,0] -> Atlantic Ocean
 * [3,1]: [3,1] -> [3,0] -> Pacific Ocean
 *        [3,1] -> [4,1] -> Atlantic Ocean
 * [4,0]: [4,0] -> Pacific Ocean
 *        [4,0] -> Atlantic Ocean
 * Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.
 *
 * Example 2:
 * Input: heights = [[1]]
 * Output: [[0,0]]
 * Explanation: The water can flow from the only cell to the Pacific and Atlantic oceans.
 *
 * @see <a href="https://leetcode.cn/problems/pacific-atlantic-water-flow/" />
 * @author Poet
 * @date 2022/11/12
 */
public class LC_417_PacificAtlanticWaterFlow {

    /* --- 这道题来自周赛：Weekly Contest 8 --- */

    /**
     * 首先拿到这道题很明显能够判断出是一个二维平面回溯算法的题目
     *
     * 方法一：深度优先搜索
     */
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][] heights;
    int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] _heights) {
        /*
            DFS+逆向求解:
            我们可以分别从太平洋与大西洋两边出发,然后从4个岸边的格子分别开始DFS
            由于水只会流向海拔小于等于自身的方向,因此反过来就是DFS前进方向是大于等于自身的格子
            我们一边DFS从太平洋开始,一边DFS从大西洋开始,然后经过符合要求的格子分别用两个矩阵记录下来
            最后统计矩阵中重合格子就是既可以流入大西洋也可以流入太平洋的格子
            m == heights.length
            n == heights[r].length
            1 <= m, n <= 200
            0 <= heights[r][c] <= 10^5
        */
        heights = _heights;
        m = heights.length;
        n = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        // 分别标记能够流入太平洋的格子(P)与流入大西洋的格子(A)
        boolean[][] P = new boolean[m][n];
        boolean[][] A = new boolean[m][n];

        // 左右两边出发:左边太平洋,右边大西洋
        for (int i = 0; i < m; i++) {
            dfs(i, 0, P);
            dfs(i, n - 1, A);
        }
        // 上下两边出发:上边太平洋,下边大西洋
        for (int j = 0; j < n; j++) {
            dfs(0, j, P);
            dfs(m - 1, j, A);
        }
        // 统计重合格子
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] && P[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j, boolean[][] ocean) {
        // 证明heights[i][j]可以流入对应海洋
        ocean[i][j] = true;
        // 遍历东南西北4个方向
        for (int[] dir : dirs) {
            int newI = i + dir[0], newJ = j + dir[1];
            // 提前排除接下来要访问的不符合要求的格子:越界||已经访问过的||海拔不符合要求的
            if (newI < 0 || newI >= m | newJ < 0 || newJ >= n || ocean[newI][newJ] || heights[newI][newJ] < heights[i][j]) {
                continue;
            }
            dfs(newI, newJ, ocean);
        }
    }

}
