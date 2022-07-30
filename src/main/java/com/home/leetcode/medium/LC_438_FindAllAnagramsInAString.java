package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. Find All Anagrams in a String （找到字符串中所有字母异位词）
 *
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 * Example 1:
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * Example 2:
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 * @see <a href="https://leetcode.com/problems/find-all-anagrams-in-a-string/" />
 * @author Poet
 * @date 2020/4/12
 */
public class LC_438_FindAllAnagramsInAString {

    /**
     * 方法一：滑动窗口
     *
     * 官方题解：https://leetcode.cn/problems/find-all-anagrams-in-a-string/solution/zhao-dao-zi-fu-chuan-zhong-suo-you-zi-mu-xzin/
     */
    public List<Integer> findAnagrams_official(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();

        //建立两个数组存放字符串中字母出现的词频，并以此作为标准比较
        int[] sCount = new int[26];
        int[] pCount = new int[26];

        //当滑动窗口的首位在s[0]处时 （相当于放置滑动窗口进入数组）
        for (int i = 0; i < pLen; i++) {
            ++sCount[s.charAt(i) - 'a']; //记录s中前pLen个字母的词频
            ++pCount[p.charAt(i) - 'a']; //记录要寻找的字符串中每个字母的词频(只用进行一次来确定)
        }

        // 判断放置处是否有异位词 (在放置时只需判断一次)
        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        //开始让窗口进行滑动
        for (int i = 0; i < sLen - pLen; i++) {  //i是滑动前的首位
            --sCount[s.charAt(i) - 'a'];         //将滑动前首位的词频删去
            ++sCount[s.charAt(i + pLen) - 'a'];  //增加滑动后最后一位的词频（以此达到滑动的效果）

            //判断滑动后处，是否有异位词
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    /**
     * 容易理解
     * solution: <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string/solution/xiao-song-man-bu-pai-xu-bi-jiao-man-hua-r1d02/" />
     */
    public List<Integer> findAnagrams_1(String s, String p) {
        int[] sArr = new int[26];
        int[] pArr = new int[26];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < p.length(); i++) {
            pArr[p.charAt(i) - 'a']++;
        }

        // [l...r]滑动窗口
        int l = 0, r = -1;
        while (l < s.length()) {
            if (r + 1 < s.length() && r - l + 1 < p.length()) {
                r++;
                sArr[s.charAt(r) - 'a']++;
            } else {
                if (isSame(sArr, pArr)) {
                    res.add(l);
                }
                sArr[s.charAt(l) - 'a']--;
                l++;
            }
        }

        return res;
    }

    /**
     * Good Solution:
     * https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92015/ShortestConcise-JAVA-O(n)-Sliding-Window-Solution
     */
    public List<Integer> findAnagrams_2(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return list;
        }
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


    /**
     * 滑动窗口
     */
    public List<Integer> findAnagrams_3(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return res;
        }

        int [] freq = new int[128];
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


    private boolean isSame(int[] sArr, int[] pArr) {
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] != pArr[i]) {
                return false;
            }
        }
        return true;
    }


//    public static void main(String[] args) {
//        LC_438_FindAllAnagramsInAString solution = new LC_438_FindAllAnagramsInAString();
//        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
//        System.out.println(solution.findAnagrams("abab", "ab"));
//    }
}
