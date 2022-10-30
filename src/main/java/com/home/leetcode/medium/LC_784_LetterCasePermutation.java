package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. Letter Case Permutation (字母大小写全排列)
 *
 * Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
 *
 * Return a list of all possible strings we could create. Return the output in any order.
 *
 * Example 1:
 * Input: s = "a1b2"
 * Output: ["a1b2","a1B2","A1b2","A1B2"]
 *
 * Example 2:
 * Input: s = "3z4"
 * Output: ["3z4","3Z4"]
 *
 * @see <a href="https://leetcode.cn/problems/letter-case-permutation/" />
 * @author Poet
 * @date 2022/10/30
 */
public class LC_784_LetterCasePermutation {

    /**
     * 回溯法 （深度优先遍历用于搜索也叫回溯算法）
     *
     * 思路很精彩，多看几遍！！！
     *
     * 这一类搜索问题是在一个隐式的树上进行的搜索问题，即「树形问题」。解决这一类问题， 先画出递归树是十分重要的，可以帮助打开思路 ，然后看着图形把代码写出来
     *
     * solution: https://leetcode.cn/problems/letter-case-permutation/solution/shen-du-you-xian-bian-li-hui-su-suan-fa-python-dai/
     */
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        char[] charArray = s.toCharArray();
        dfs(charArray, 0, res);
        return res;
    }

    private void dfs(char[] charArray, int index, List<String> res) {
        if (index == charArray.length) {
            res.add(new String(charArray));
            return;
        }

        dfs(charArray, index + 1, res);
        if (Character.isLetter(charArray[index])) {
            charArray[index] ^= 32;
            dfs(charArray, index + 1, res);
        }
    }

}
