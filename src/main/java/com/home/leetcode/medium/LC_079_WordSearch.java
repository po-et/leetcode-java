package com.home.leetcode.medium;

/**
 * 79. Word Search （单词搜索）
 *
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * Example 1:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 *
 * Example 2:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 *
 * Follow up: Could you use search pruning to make your solution faster with a larger board?
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 *
 * @see <a href="https://leetcode.cn/problems/word-search/" />
 * @author Poet
 * @date 2022/5/29
 */
public class LC_079_WordSearch {

    private int m, n;
    private boolean[][] visited;
    // 二维数组移动的坐标：上右下左
    private int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (searchWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 从board[startX, startY]开始，寻找word[index...word.size())
    private boolean searchWord(char[][] board, String word, int index, int startX, int startY) {
        if (index == word.length() - 1) {
            return board[startX][startY] == word.charAt(index);
        }

        if (board[startX][startY] == word.charAt(index)) {
            visited[startX][startY] = true;
            // 从startX, startY出发，向四个方向寻找
            for (int i = 0; i < 4; i++) {
                int newX = startX + directions[i][0];
                int newY = startY + directions[i][1];
                if (inArea(newX, newY) && !visited[newX][newY]) {
                    if (searchWord(board, word, index + 1, newX, newY)) {
                        return true;
                    }
                }
            }
            visited[startX][startY] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}
