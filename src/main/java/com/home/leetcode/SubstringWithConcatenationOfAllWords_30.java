package com.home.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. Substring With Concatenation Of All Words
 *  必须连续的包含所有的元素，而且给定数组的长度都相等
 *
 * For example:
 *  s: "barfoothefoobarman"
 *  words: ["foo", "bar"]
 *  => return the indices: [0,9]
 *  (orders does not matter)
 *
 * Created by Poet on 2019-01-13.
 */
public class SubstringWithConcatenationOfAllWords_30 {

    /**
     * 没有什么技巧，一道实现题
     *  使用hashmap来存、注意边界条件！
     *
     * time: O(n^2)
     * space: O(n)
     */
    public List<Integer> findSubstring(String s, String[] words) {
        if(s == null || words == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int n = words.length;
        int m = words[0].length();

        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (int i = 0; i <= s.length() - n*m; i++) {
            Map<String, Integer> copy = new HashMap<>(map);
            int j = i;
            int k = n;
            while (k > 0) {
                String str = s.substring(j, j+m);
                if (!copy.containsKey(str) || copy.get(str) < 1) {
                    break;
                }
                copy.put(str, copy.get(str) - 1);
                k--;
                j += m;
            }
            if(k == 0) res.add(i);
        }
        return res;
    }
}
