package com.home.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 2347. Best Poker Hand (最好的扑克手牌)
 *
 * You are given an integer array ranks and a character array suits. You have 5 cards where the ith card has a rank of ranks[i] and a suit of suits[i].
 *
 * The following are the types of poker hands you can make from best to worst:
 *
 * "Flush": Five cards of the same suit.
 * "Three of a Kind": Three cards of the same rank.
 * "Pair": Two cards of the same rank.
 * "High Card": Any single card.
 * Return a string representing the best type of poker hand you can make with the given cards.
 *
 * Note that the return values are case-sensitive.
 *
 * Example 1:
 * Input: ranks = [13,2,3,1,9], suits = ["a","a","a","a","a"]
 * Output: "Flush"
 * Explanation: The hand with all the cards consists of 5 cards with the same suit, so we have a "Flush".
 *
 * Example 2:
 * Input: ranks = [4,4,2,4,4], suits = ["d","a","a","b","c"]
 * Output: "Three of a Kind"
 * Explanation: The hand with the first, second, and fourth card consists of 3 cards with the same rank, so we have a "Three of a Kind".
 * Note that we could also make a "Pair" hand but "Three of a Kind" is a better hand.
 * Also note that other cards could be used to make the "Three of a Kind" hand.
 *
 * Example 3:
 * Input: ranks = [10,10,2,12,9], suits = ["a","b","c","a","d"]
 * Output: "Pair"
 * Explanation: The hand with the first and second card consists of 2 cards with the same rank, so we have a "Pair".
 * Note that we cannot make a "Flush" or a "Three of a Kind".
 *
 * @see <a href="https://leetcode.cn/problems/best-poker-hand/" />
 * @author Poet
 * @date 2023/2/20
 */
public class LC_2347_BestPokerHand {

    /**
     * 方法一：哈希表 + 计数
     *
     * time:  O(n)
     * space: O(n)
     */
    public String bestHand(int[] ranks, char[] suits) {
        boolean isFlush = true;
        for (int i = 1; i < suits.length; i++) {
            if (suits[i] != suits[0]) {
                isFlush = false;
                break;
            }
        }
        if (isFlush) {
            return "Flush";
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < ranks.length; i++) {
            map.put(ranks[i], map.getOrDefault(ranks[i], 0) + 1);
            if (map.get(ranks[i]) == 3) {
                return "Three of a Kind";
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) {
                return "Pair";
            }
        }

        return "High Card";
    }
}
