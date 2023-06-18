package com.home.leetcode.medium;

/**
 * 200. Number of Islands（岛屿数量）
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically.
 *
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 * Input:
 *    11110
 *    11010
 *    11000
 *    00000
 * Output: 1
 *
 * Example 2:
 * Input:
 *    11000
 *    11000
 *    00100
 *    00011
 * Output: 3
 *
 * @see <a href="https://leetcode.cn/problems/number-of-islands/" />
 * @author Poet
 * @date 2020/5/16
 */
public class LC_200_NumberOfIslands {

    private int m, n;
    // 访问标记矩阵
    private boolean[][] visited;
    // 位移坐标
    private final int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    /**
     * Flood fill算法（liuyubo讲解）
     *
     * 思路类似 {@link LC_079_WordSearch}
     *
     * time:  O(M x N) 其中 M 和 N 分别为行数和列数
     * space: O(M x N) 在最坏情况下，整个网格均为陆地，深度优先搜索的深度达到 M x N
     */
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    // 从grid[x][y]的位置开始，进行flood fill
    // 保证(x,y)合法，且grid[x][y]是没有被访问过的陆地
    private void dfs(char[][] grid, int x, int y) {
        // 注意：没有递归条件
        // 因为合法性的判断，已经融合到了下面递归开始前的if判断中

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] == '1') {
                dfs(grid, newX, newY);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }




    /**
     * Flood fill算法
     * Solution: https://blog.csdn.net/DERRANTCM/article/details/47970795
     */
    public int numIslands_2(char[][] grid) {
        // 参数校验
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        // 元素默认值是false
        boolean[][] visited = new boolean[m][n];
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果此位置没有被访问过，并且此位置是岛，就广度优先遍历
                if (!visited[i][j] && grid[i][j] == '1') {
                    res++;
                    dfsSearch(grid, m, n, i, j, visited);
                }
            }
        }
        return res;
    }

    /**
     * 深度优先搜索
     *
     * @param grid    网格
     * @param visited 访问标记矩阵
     * @param i       横坐标
     * @param j       纵坐标
     */
    private void dfsSearch(char[][] grid, int m, int n, int i, int j, boolean[][] visited) {
        // 递归结束条件
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == '0') {
            return;
        }

        visited[i][j] = true;

        dfsSearch(grid, m, n, i - 1, j, visited);   // 上
        dfsSearch(grid, m, n, i, j + 1, visited);   // 右
        dfsSearch(grid, m, n, i + 1, j, visited);   // 下
        dfsSearch(grid, m, n, i, j - 1, visited);   // 左
    }

}
