package com.home.leetcode.easy;

import java.util.*;

/**
 * 2351. First Letter to Appear Twice (第一个出现两次的字母)
 *
 * Given a string s consisting of lowercase English letters, return the first letter to appear twice.
 *
 * Note:
 *  - A letter a appears twice before another letter b if the second occurrence of a is before the second occurrence of b.
 *  - s will contain at least one letter that appears twice.
 *
 *
 * Example 1:
 * Input: s = "abccbaacz"
 * Output: "c"
 * Explanation:
 * The letter 'a' appears on the indexes 0, 5 and 6.
 * The letter 'b' appears on the indexes 1 and 4.
 * The letter 'c' appears on the indexes 2, 3 and 7.
 * The letter 'z' appears on the index 8.
 * The letter 'c' is the first letter to appear twice, because out of all the letters the index of its second occurrence is the smallest.
 *
 * Example 2:
 * Input: s = "abcdd"
 * Output: "d"
 * Explanation:
 * The only letter that appears twice is 'd' so we return 'd'.
 *
 * @see <a href="https://leetcode.cn/problems/first-letter-to-appear-twice/" />
 * @author poet
 * @date 2023/1/1
 */
public class LC_2351_FirstLetterToAppearTwice {

    /**
     * 方法一：哈希表
     *
     * time:  O(n)
     * space: O(∣Σ∣) 其中 \SigmaΣ 是字符集，在本题中字符串只包含小写字母，因此 ∣Σ∣=26
     */
    public char repeatedCharacter(String s) {
        Set<Character> seen = new HashSet<Character>();
        for (char ch : s.toCharArray()) {
            if (seen.contains(ch)) {
                return ch;
            } else {
                seen.add(ch);
            }
        }
        return ' ';
    }

}
