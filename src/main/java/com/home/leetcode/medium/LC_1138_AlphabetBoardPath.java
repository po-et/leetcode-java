package com.home.leetcode.medium;

/**
 * 1138. Alphabet Board Path
 *
 * On an alphabet board, we start at position (0, 0), corresponding to character board[0][0].
 *
 * Here, board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"], as shown in the diagram below.
 *
 * We may make the following moves:
 * 'U' moves our position up one row, if the position exists on the board;
 * 'D' moves our position down one row, if the position exists on the board;
 * 'L' moves our position left one column, if the position exists on the board;
 * 'R' moves our position right one column, if the position exists on the board;
 * '!' adds the character board[r][c] at our current position (r, c) to the answer.
 * (Here, the only positions that exist on the board are positions with letters on them.)
 *
 * Return a sequence of moves that makes our answer equal to target in the minimum number of moves.  You may return any path that does so.
 *
 * Example 1:
 * Input: target = "leet"
 * Output: "DDR!UURRR!!DDD!"
 *
 * Example 2:
 * Input: target = "code"
 * Output: "RR!DDRR!UUL!R!"
 *
 * @see <a href="https://leetcode.cn/problems/alphabet-board-path/" />
 * @author Poet
 * @date 2023/2/12
 */
public class LC_1138_AlphabetBoardPath {

    /**
     * 方法一：直接模拟
     *
     * 特殊：为了保证含有字符 ‘z’ 时能够正常移动，每次移动时优先保证选择上移和左移即可
     */
    public String alphabetBoardPath(String target) {
        int cx = 0, cy = 0;
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            int nx = (c - 'a') / 5;
            int ny = (c - 'a') % 5;
            if (nx < cx) {
                for (int j = 0; j < cx - nx; j++) {
                    res.append('U');
                }
            }
            if (ny < cy) {
                for (int j = 0; j < cy - ny; j++) {
                    res.append('L');
                }
            }
            if (nx > cx) {
                for (int j = 0; j < nx - cx; j++) {
                    res.append('D');
                }
            }
            if (ny > cy) {
                for (int j = 0; j < ny - cy; j++) {
                    res.append('R');
                }
            }
            res.append('!');
            cx = nx;
            cy = ny;
        }

        return res.toString();
    }

}
