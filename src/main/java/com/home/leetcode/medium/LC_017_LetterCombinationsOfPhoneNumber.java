package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. Letter Combinations of a Phone Number
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example 1:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * Example 2:
 * Input: digits = ""
 * Output: []
 *
 * Example 3:
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 * @see <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/" />
 * @author Poet
 * @date 2020/5/5
 */
public class LC_017_LetterCombinationsOfPhoneNumber {

    private List<String> res = new ArrayList<>();
    private String[] lettersArray = {
            " ",    // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    /**
     * 方法一：递归（liuyubo讲解）
     */
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }

        findCombination(digits, 0, "");
        return res;
    }

    // preStr中保存了此时从digits[0...index-1]翻译得到的一个字母字符串，
    // 寻找和digits[index]匹配的字母，获得digits[0...index]翻译得到的解
    private void findCombination(String digits, int index, String preStr) {
        if (index == digits.length()) {
            res.add(preStr);
            return;
        }

        char digit = digits.charAt(index);
        String letters = lettersArray[digit - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits, index + 1, preStr + letters.charAt(i));
        }
    }


    /**
     * 方法二：回溯法（backtrack）
     * @see <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/solution/dian-hua-hao-ma-de-zi-mu-zu-he-by-leetcode-solutio/" />
     *
     * time: O(3^m * 4^n) 其中 m 是输入中对应 3 个字母的数字个数（包括数字 2、3、4、5、6、8），n 是输入中对应 4 个字母的数字个数（包括数字 7、9）
     * spave: O(m+n) 其中 m 是输入中对应 3 个字母的数字个数，n 是输入中对应 4 个字母的数字个数，m+n 是输入数字的总个数
     */
    public List<String> letterCombinations_BackTrack(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    private void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);

        for (int i = 0; i < letters.length(); i++) {
            combination.append(letters.charAt(i));
            backtrack(combinations, phoneMap, digits, index + 1, combination);
            combination.deleteCharAt(index);
        }
    }

}
