package com.home.leetcode.easy;

/**
 * 2660. Determine the Winner of a Bowling Game (保龄球游戏的获胜者)
 *
 * You are given two 0-indexed integer arrays player1 and player2, that represent the number of pins that player 1 and player 2 hit in a bowling game, respectively.
 *
 * The bowling game consists of n turns, and the number of pins in each turn is exactly 10.
 *
 * Assume a player hit xi pins in the ith turn. The value of the ith turn for the player is:
 *  - 2xi if the player hit 10 pins in any of the previous two turns.
 *  - Otherwise, It is xi.
 * The score of the player is the sum of the values of their n turns.
 *
 * Return
 *  - 1 if the score of player 1 is more than the score of player 2,
 *  - 2 if the score of player 2 is more than the score of player 1, and
 *  - 0 in case of a draw.
 *
 * Example 1:
 * Input: player1 = [4,10,7,9], player2 = [6,5,2,3]
 * Output: 1
 * Explanation: The score of player1 is 4 + 10 + 2*7 + 2*9 = 46.
 * The score of player2 is 6 + 5 + 2 + 3 = 16.
 * Score of player1 is more than the score of player2, so, player1 is the winner, and the answer is 1.
 *
 * @see <a href="https://leetcode.cn/problems/determine-the-winner-of-a-bowling-game/description/" />
 * @author Poet
 * @date 2023/12/27
 */
public class LC_2660_DetermineTheWinnerOfABowlingGame {

    /**
     * 方法一：模拟
     */
    public int isWinner(int[] player1, int[] player2) {
        int s1 = score(player1);
        int s2 = score(player2);
        return s1 == s2 ? 0 : s1 > s2 ? 1 : 2;
    }

    public int score(int[] player) {
        int res = 0;
        for (int i = 0; i < player.length; i++) {
            if ((i > 0 && player[i - 1] == 10) || (i > 1 && player[i - 2] >= 10)) {
                res += 2 * player[i];
            } else {
                res += player[i];
            }
        }
        return res;
    }

}
