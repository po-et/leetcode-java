package com.home.leetcode.medium;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 *
 * @see <a href="https://leetcode.com/problems/number-of-islands/" />
 * @author Poet
 * @date 2020/5/16
 */
public class NumberOfIslands_200 {

    /**
     * Floodfill算法
     * Solution: https://blog.csdn.net/DERRANTCM/article/details/47970795
     */
    public int numIslands(char[][] grid) {
        // 参数校验
        if(grid==null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;
        int result = 0;

        // 元素默认值是false
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // 如果此位置没有被访问过，并且此位置是岛，就广度优先遍历
                if (!visited[i][j] && grid[i][j] == '1') {
                    result++;
                    dfsSearch(grid, m, n, i, j, visited);
                }
            }
        }
        return result;
    }

    /**
     * 深度优先搜索
     * @param grid 网格
     * @param visited 访问标记矩阵
     * @param i 横坐标
     * @param j 纵坐标
     */
    private void dfsSearch(char[][] grid, int m, int n, int i, int j, boolean[][] visited) {
        // 递归结束条件
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == '0') {
            return;
        }

        visited[i][j] = true;

        dfsSearch(grid, m, n, i-1, j, visited);   // 上
        dfsSearch(grid, m, n, i, j+1, visited);   // 右
        dfsSearch(grid, m, n, i+1, j, visited);   // 下
        dfsSearch(grid, m, n, i, j-1, visited);   // 左
    }


}
