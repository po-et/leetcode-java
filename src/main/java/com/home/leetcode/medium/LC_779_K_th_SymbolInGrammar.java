package com.home.leetcode.medium;

/**
 * 779. K-th Symbol in Grammar (第K个语法符号)
 *
 * We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every subsequent row,
 * we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
 *
 * For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
 * Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.
 *
 * Example 1:
 * Input: n = 1, k = 1
 * Output: 0
 * Explanation: row 1: 0
 *
 * Example 2:
 * Input: n = 2, k = 1
 * Output: 0
 * Explanation:
 * row 1: 0
 * row 2: 01
 *
 * Example 3:
 * Input: n = 2, k = 2
 * Output: 1
 * Explanation:
 * row 1: 0
 * row 2: 01
 *
 * @see <a href="https://leetcode.cn/problems/k-th-symbol-in-grammar" />
 * @author Poet
 * @date 2022/10/20
 */
public class LC_779_K_th_SymbolInGrammar {

    /* --- 这道题来自：Weekly Contest 70 --- */

    // 参考答案...
    /**
     * 方法二：找规律 + 递归
     */
    public int kthGrammar(int n, int k) {
        if (k == 1) {
            return 0;
        }
        if (k > (1 << (n - 2))) {
            return 1 ^ kthGrammar(n - 1, k - (1 << (n - 2)));
        }
        return kthGrammar(n - 1, k);
    }


    public static void main(String[] args) {
        LC_779_K_th_SymbolInGrammar solution = new LC_779_K_th_SymbolInGrammar();
        int res = solution.kthGrammar(2, 1);
        System.out.println(res);
    }

}
