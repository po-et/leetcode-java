package com.home.leetcode;

import java.util.HashSet;

/**
 * 36. Valid Soduku
 *
 * Created by Poet on 2019-01-16.
 */
public class ValidSudoku_36 {

    /**
     * 推荐的写法：三个HashSet

     0 1 2 3 4 5 6 7 8
     0 0 0 0 0 0 0 0 0  rowIndex = 0
     0 3 6 0 3 6 0 3 6  colIndex = 3

     0 0 0 1 1 1 2 2 2   j / 3
     0 1 2 0 1 2 0 1 2   j % 3

    判断九宫格时，按从左到右，下移，再从左到右的顺序判断

        time: O(n^2)  (9*9)
        space: O(n)
     */
    public boolean isValidSoduku1(char[][] board){
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] != '.' && !rows.add(board[i][j])) return false;
                if(board[j][i] != '.' && !cols.add(board[j][i])) return false;

                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);

                if (board[rowIndex + j / 3][colIndex + j % 3] != '.' && !cube.add(board[rowIndex + j / 3][colIndex + j % 3])) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * 这种方法参考一下就行
     * @param board
     * @return
     */
    public boolean isValidSoduku2(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') continue;
                if(!valid(board,i,j)) return false;
            }
        }
        return true;
    }

    public boolean valid(char[][] board, int i, int j) {
        for (int row = 0; row < board.length; row++) {
            if(row == i) continue;
            if(board[row][j] == board[i][j]) return false;
        }
        for (int col = 0; col < board[0].length; col++) {
            if(col == j) continue;
            if(board[i][col] == board[i][j]) return false;
        }
        for (int row = (i / 3) * 3; row < (i / 3 + 1) * 3; row++) {
            for (int col = (j / 3) * 3; col < (j / 3 + 1) * 3; col++) {
                if(row == i&& col == j) continue;
                if(board[row][col] == board[i][j]) return false;
            }
        }
        return true;
    }
}
