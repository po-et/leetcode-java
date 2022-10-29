package com.home.leetcode.easy;

import java.util.List;

/**
 * 1773. Count Items Matching a Rule (统计匹配检索规则的物品数量)
 *
 * You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of the ith item.
 * You are also given a rule represented by two strings, ruleKey and ruleValue.
 *
 * The ith item is said to match the rule if one of the following is true:
 *      ruleKey == "type" and ruleValue == typei.
 *      ruleKey == "color" and ruleValue == colori.
 *      ruleKey == "name" and ruleValue == namei.
 *
 * Return the number of items that match the given rule.
 *
 * Example 1:
 * Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
 * Output: 1
 * Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].
 *
 * Example 2:
 * Input: items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
 * Output: 2
 * Explanation: There are only two items matching the given rule, which are ["phone","blue","pixel"] and ["phone","gold","iphone"]. Note that the item ["computer","silver","phone"] does not match.
 *
 * @see <a href="https://leetcode.cn/problems/count-items-matching-a-rule/" />
 * @author Poet
 * @date 2022/10/29
 */
public class LC_1773_CountItemsMatchingARule {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        for (List<String> item : items) {
            if (ruleKey.equals("type") && ruleValue.equals(item.get(0))) {
                res++;
            } else if (ruleKey.equals("color") && ruleValue.equals(item.get(1))) {
                res++;
            } else if (ruleKey.equals("name") && ruleValue.equals(item.get(2))) {
                res++;
            }
        }
        return res;
    }
}
