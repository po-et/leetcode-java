package com.home.leetcode.jianzhi_offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题48. 最长不含重复字符的子字符串
 *
 * @author Poet
 * @date 2020/6/1
 */
public class Offer_48_LongestSubstringWithoutRepeatingCharacters {

    // s[l...r] 为滑动窗口
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        int l = 0, r = -1;
        while (l < s.length()) {
            if (r + 1 < s.length() && !set.contains(s.charAt(r + 1))) {
                set.add(s.charAt(r + 1));
                r++;
            } else {
                set.remove(s.charAt(l));
                l++;
            }
            res = Math.max(res, (r - l + 1));
        }
        return res;
    }

}
