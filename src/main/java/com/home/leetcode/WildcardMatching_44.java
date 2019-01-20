package com.home.leetcode;

/**
 * 44. Wildcard Matching

 Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).

 注：Facebook面试常考

 * @leetcode: https://leetcode.com/problems/wildcard-matching/
 * Created by Poet on 2019-01-20.
 */
public class WildcardMatching_44 {

    /**
     * time: O(n)
     * space: O(1)
     */
    public boolean isMatch(String s, String p) {
        int sp = 0;
        int pp = 0;
        int match = 0;
        int star = -1;
        while (sp < s.length()) {
            if (pp < p.length() && (s.charAt(sp) == p.charAt(pp)) || p.charAt(pp) == '?') {
                sp++;
                pp++;
            } else if (pp < p.length() && p.charAt(pp) == '*') {
                star = pp;
                match = sp;
                pp++;
            } else if (star != -1) {
                pp = star + 1;
                match++;
                sp = match;
            } else return false;
        }
        while (pp < p.length() && p.charAt(pp) == '*') {
            pp++;
        }
        return pp == p.length();
    }
}
