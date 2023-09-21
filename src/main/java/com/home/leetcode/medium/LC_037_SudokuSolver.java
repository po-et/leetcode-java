package com.home.leetcode.medium;

/**
 * 37. Sudoku Solver
 *
 * @see <a href = "https://leetcode.cn/problems/sudoku-solver/" />
 * Created by Poet on 2019-01-16.
 */
public class LC_037_SudokuSolver {

    /**
     * DFS算法
     *
     * time: 不知道  （目前没有比较权威的答案）
     * space: 不知道
     */
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            }
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) return false;
            if (board[row][i] != '.' && board[row][i] == c) return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i / 3] != '.'
                    && board[3 * (row / 3) + i / 3][3 * (col / 3) + i / 3] == c) {
                return false;
            }
        }
        return true;
    }
}
