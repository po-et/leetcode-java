package com.home.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer (罗马数字转整数)
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * 规律：左边的数字如果小于右边的数字 = 右 - 左
 *
 * @see <a href="https://leetcode.cn/problems/roman-to-integer/"/>
 * Created by Poet on 2019-01-10.
 */
public class LC_013_RomanToInteger {

    /**
     * 方法一：模拟
     *
     * 官方题解：https://leetcode.cn/problems/roman-to-integer/solution/luo-ma-shu-zi-zhuan-zheng-shu-by-leetcod-w55p/
     *
     * time:  O(n)
     * space: O(1)
     */
    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }







    @Deprecated
    static int romanToInt_deprecated(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int res = toNumber(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            if (toNumber(s.charAt(i)) > toNumber(s.charAt(i - 1))) {
                res += toNumber(s.charAt(i)) - 2 * toNumber(s.charAt(i - 1));
            } else {
                res += toNumber(s.charAt(i));
            }
        }
        return res;
    }

    static int toNumber(char c) {
        int res = 0;
        switch (c) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
        }
        return res;
    }
}
