package com.home.jianzhi_offer_II;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 034. 外星语言是否排序
 *
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 *
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 *
 * 示例 1：
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 *
 * 示例 2：
 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * 输出：false
 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 *
 * 示例 3：
 * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * 输出：false
 * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
 *
 * 注意：本题与主站 953 题相同： https://leetcode-cn.com/problems/verifying-an-alien-dictionary/
 *
 * @see <a href="https://leetcode.cn/problems/lwyVBB" />
 * @author Poet
 * @date 2023/3/23
 */
public class Offer_II_034_VerifyingAnAlienDictionary {

    /**
     * 方法一：直接遍历
     */
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 1; i < words.length; i++) {
            String pre = words[i - 1];
            String cur = words[i];
            boolean isValid = false;
            for (int j = 0; j < pre.length() && j < cur.length(); j++) {
                int preIndex = map.get(pre.charAt(j));
                int curIndex = map.get(cur.charAt(j));
                if (preIndex > curIndex) {
                    return false;
                } else if (preIndex < curIndex) {
                    isValid = true;
                    break;
                }
            }

            if (!isValid) {
                // 前k个数相等，比较两个字符串的长度
                if (pre.length() > cur.length()) {
                    return false;
                }
            }
        }
        return true;
    }

}
