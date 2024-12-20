package com.home.leetcode.medium;

/**
 * 1234. Replace the Substring for Balanced String
 *
 * You are given a string s of length n containing only four kinds of characters: 'Q', 'W', 'E', and 'R'.
 *
 * A string is said to be balanced if each of its characters appears n / 4 times where n is the length of the string.
 *
 * Return the minimum length of the substring that can be replaced with any other string of the same length to make s balanced. If s is already balanced, return 0.
 *
 * Example 1:
 * Input: s = "QWER"
 * Output: 0
 * Explanation: s is already balanced.
 *
 * Example 2:
 * Input: s = "QQWE"
 * Output: 1
 * Explanation: We need to replace a 'Q' to 'R', so that "RQWE" (or "QRWE") is balanced.
 *
 * Example 3:
 * Input: s = "QQQW"
 * Output: 2
 * Explanation: We can replace the first "QQ" to "ER".
 *
 * @see <a href="https://leetcode.cn/problems/replace-the-substring-for-balanced-string/" />
 * @author Poet
 * @date 2023/2/13
 */
public class LC_1234_ReplaceTheSubstringForBalancedString {

    /**
     * 方法一：滑动窗口
     *
     * time:  O(n)   其中 n 为 s 的长度
     * space: O(∣Σ∣) ∣Σ∣为字符集的大小
     */
    public int balancedString(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[idx(c)]++;
        }

        int partial = s.length() / 4;
        int res = s.length();

        if (check(cnt, partial)) {
            return 0;
        }

        for (int l = 0, r = 0; l < s.length(); l++) {
            while (r < s.length() && !check(cnt, partial)) {
                cnt[idx(s.charAt(r))]--;
                r++;
            }
            if (!check(cnt, partial)) {
                break;
            }
            res = Math.min(res, r - l);
            cnt[idx(s.charAt(l))]++;
        }
        return res;
    }

    public int idx(char c) {
        return c - 'A';
    }

    public boolean check(int[] cnt, int partial) {
        if (cnt[idx('Q')] > partial || cnt[idx('W')] > partial || cnt[idx('E')] > partial || cnt[idx('R')] > partial) {
            return false;
        }
        return true;
    }


//    public int balancedString(String s) {
//        int n = s.length();
//        int average = n / 4;
//        Map<Character, Integer> map = new HashMap<>();
//        int res = 0;
//        for (char ch : s.toCharArray()) {
//            map.put(ch, map.getOrDefault(ch, 0) + 1);
//        }
//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            Integer count = entry.getValue();
//            if (count > average) {
//                res += count - average;
//            }
//        }
//        return res;
//    }
}
