package com.home.leetcode.medium;

/**
 * 299. Bulls and Cows (猜数字游戏)
 *
 * You are playing the Bulls and Cows game with your friend.
 *
 * You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:
 *
 * The number of "bulls", which are digits in the guess that are in the correct position.
 * The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
 * Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.
 *
 * The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows. Note that both secret and guess may contain duplicate digits.
 *
 * Example 1:
 * Input: secret = "1807", guess = "7810"
 * Output: "1A3B"
 * Explanation: Bulls are connected with a '|' and cows are underlined:
 * "1807"
 *   |
 * "7810"
 *
 * Example 2:
 * Input: secret = "1123", guess = "0111"
 * Output: "1A1B"
 * Explanation: Bulls are connected with a '|' and cows are underlined:
 * "1123"        "1123"
 *   |      or     |
 * "0111"        "0111"
 * Note that only one of the two unmatched 1s is counted as a cow since the non-bull digits can only be rearranged to allow one 1 to be a bull.
 *
 * @see <a href="https://leetcode.cn/problems/bulls-and-cows/" />
 * @author Poet
 * @date 2022/7/31
 */
public class LC_299_BullsAndCows {

    /**
     * 方法一：遍历
     *
     * time:  O(N) 其中 N 是字符串 secret 的长度
     * space: O(C) 需要常数个空间统计字符出现次数，由于我们统计的是数字字符，因此 C=10
     */
    public String getHint(String secret, String guess) {
        int numA = 0, numB = 0;
        int[] countS = new int[10];
        int[] countG = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                numA++;
            } else {
                countS[secret.charAt(i) - '0']++;
                countG[guess.charAt(i) - '0']++;
            }
        }

        for (int i = 0; i < 10; i++) {
            numB += Math.min(countS[i], countG[i]);
        }

        return numA + "A" + numB + "B";
    }
}
