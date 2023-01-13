package com.home.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 2287. Rearrange Characters to Make Target String (重排字符形成目标字符串)
 *
 * You are given two 0-indexed strings s and target. You can take some letters from s and rearrange them to form new strings.
 *
 * Return the maximum number of copies of target that can be formed by taking letters from s and rearranging them.
 *
 * Example 1:
 * Input: s = "ilovecodingonleetcode", target = "code"
 * Output: 2
 * Explanation:
 * For the first copy of "code", take the letters at indices 4, 5, 6, and 7.
 * For the second copy of "code", take the letters at indices 17, 18, 19, and 20.
 * The strings that are formed are "ecod" and "code" which can both be rearranged into "code".
 * We can make at most two copies of "code", so we return 2.
 *
 * Example 2:
 * Input: s = "abcba", target = "abc"
 * Output: 1
 * Explanation:
 * We can make one copy of "abc" by taking the letters at indices 0, 1, and 2.
 * We can make at most one copy of "abc", so we return 1.
 * Note that while there is an extra 'a' and 'b' at indices 3 and 4, we cannot reuse the letter 'c' at index 2, so we cannot make a second copy of "abc".
 *
 * Example 3:
 * Input: s = "abbaccaddaeea", target = "aaaaa"
 * Output: 1
 * Explanation:
 * We can make one copy of "aaaaa" by taking the letters at indices 0, 3, 6, 9, and 12.
 * We can make at most one copy of "aaaaa", so we return 1.
 *
 * @see <a href="https://leetcode.cn/problems/rearrange-characters-to-make-target-string/" />
 * @author Poet
 * @date 2023/1/13
 */
public class LC_2287_RearrangeCharactersToMakeTargetString {

    /**
     * 方法一：哈希表计数
     */
    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> sCounts = new HashMap<>();
        Map<Character, Integer> targetCounts = new HashMap<>();

        int n = s.length(), m = target.length();
        for (int i = 0; i < m; i++) {
            char c = target.charAt(i);
            targetCounts.put(c, targetCounts.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (targetCounts.containsKey(c)) {
                sCounts.put(c, sCounts.getOrDefault(c, 0) + 1);
            }
        }

        int res = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : targetCounts.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            int totalCount = sCounts.containsKey(c) ? sCounts.get(c) : 0;
            res = Math.min(res, totalCount / count);
            if (res == 0) {
                return 0;
            }
        }
        return res;
    }


    // 自己做，wrong answer
//    public int rearrangeCharacters_(String s, String target) {
//        int n = target.length();
//        Map<Character, Integer> dict = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            dict.put(target.charAt(i), dict.getOrDefault(target.charAt(i), 0) + 1);
//        }
//
//        int l = 0, r = 0;
//        int res = 0;
//        while (l < s.length() - n) {
//            if (dict.containsKey(s.charAt(l))) {
//                r = l + 1;
//                Map<Character, Integer> tmpMap = dict;
//                while (r - l < n) {
//                    if (tmpMap.containsKey(s.charAt(r))) {
//                        tmpMap.put(s.charAt(r), tmpMap.get(s.charAt(r)) - 1);
//                        r++;
//                    } else {
//                        l = r + 1;
//                        break;
//                    }
//                }
//                if (r - l == n) {
//                    res++;
//                    l = r + 1;
//                }
//            } else {
//                l++;
//            }
//        }
//        return res;
//    }



}
