package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * @see <a href="https://leetcode.com/problems/find-all-anagrams-in-a-string/" />
 * @author Poet
 * @date 2020/4/12
 */
public class FindAllAnagramsInAString_438 {


    public static void main(String[] args) {
        FindAllAnagramsInAString_438 solution = new FindAllAnagramsInAString_438();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
        System.out.println(solution.findAnagrams("abab", "ab"));
    }


    int [] freq = new int[128];

    /**
     * 滑动窗口问题
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length())
            return res;

        for (char c : p.toCharArray()) {
            freq[c]++;
        }
        int count = p.length();

        int start = 0, end = 0;
        while (end < s.length()) {

            if (freq[s.charAt(end)] >= 1) {
                count--;
            }
            freq[s.charAt(end)]--;
            end++;

            if (count == 0) res.add(start);

            if (end - start == p.length()) {
                if (freq[s.charAt(start)] >= 0) {
                    count++;
                }
                freq[s.charAt(start)]++;
                start++;
            }
        }

        return res;
    }


    /**
     * Good Solution:
     * @url https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92015/ShortestConcise-JAVA-O(n)-Sliding-Window-Solution
     */
    public List<Integer> findAnagramsStandard(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[256]; //character hash
        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right++)]-- >= 1) count--;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) list.add(left);

            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }
        return list;
    }
}
