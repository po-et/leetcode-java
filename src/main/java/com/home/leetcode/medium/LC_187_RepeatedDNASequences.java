package com.home.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 187. Repeated DNA Sequences
 *
 * The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
 *
 * For example, "ACGAATTCCG" is a DNA sequence.
 * When studying DNA, it is useful to identify repeated sequences within the DNA.
 *
 * Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.
 *
 * Example 1:
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * Output: ["AAAAACCCCC","CCCCCAAAAA"]
 *
 * Example 2:
 * Input: s = "AAAAAAAAAAAAA"
 * Output: ["AAAAAAAAAA"]
 *
 * @see <a href="https://leetcode.cn/problems/repeated-dna-sequences/" />
 * @author Poet
 * @date 2023/11/5
 */
public class LC_187_RepeatedDNASequences {

    /**
     * 方法一：哈希表
     */
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new LinkedList<>();
        final int len = 10;
        int n = s.length();

        for (int i = 0; i <= n - len; i++) {
            String subStr = s.substring(i, i + len);
            map.put(subStr, map.getOrDefault(subStr, 0) + 1);
            if (map.get(subStr) == 2) {
                res.add(subStr);
            }
        }
        return res;
    }

}
