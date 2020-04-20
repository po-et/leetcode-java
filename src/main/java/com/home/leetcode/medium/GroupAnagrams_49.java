package com.home.leetcode.medium;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * @see <a href = "https://leetcode.com/problems/group-anagrams/" />
 * @author Poet
 * @date 2020/4/20
 */
public class GroupAnagrams_49 {

    public static void main(String[] args) {
        GroupAnagrams_49 solution = new GroupAnagrams_49();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (Objects.isNull(strs) || strs.length == 0) {
            throw new IllegalArgumentException("strs is not valid!");
        }

        Map<String, List<String>> record = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);

            if (record.containsKey(sortedStr)) {
                record.get(sortedStr).add(str);
            } else {
                List<String> innerList = new ArrayList<>();
                innerList.add(str);
                record.put(sortedStr, innerList);
            }
        }

        List<List<String>> ret = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : record.entrySet()) {
            ret.add(entry.getValue());
        }

        return ret;
    }

}
