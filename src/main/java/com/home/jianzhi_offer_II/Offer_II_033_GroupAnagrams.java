package com.home.jianzhi_offer_II;

import java.util.*;

/**
 * 剑指 Offer II 033. 变位词组
 *
 * 给定一个字符串数组 strs ，将 变位词 组合在一起。 可以按任意顺序返回结果列表。
 *
 * 注意：若两个字符串中每个字符出现的次数都相同，则称它们互为变位词。
 *
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 *
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 * 注意：本题与主站 49 题相同： https://leetcode-cn.com/problems/group-anagrams/
 *
 * @see <a href="https://leetcode.cn/problems/sfvd7V" />
 * @author Poet
 * @date 2023/3/23
 */
public class Offer_II_033_GroupAnagrams {

    /**
     * 方法一：排序
     *
     * time:  O(NKlogK)
     * space: O(NK)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = new String(chars);
            List<String> list = map.getOrDefault(sortStr, new ArrayList<>());
            list.add(str);
            map.put(sortStr, list);
        }

        return new ArrayList<List<String>>(map.values());
    }

    /**
     * 方法二：计数
     */

}
