package com.home.jianzhi_offer;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 *
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 示例 1:
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * @see <a href="https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof" />
 * @author Poet
 * @date 2022/6/14
 */
public class Offer_46_TranslateNum {

    /**
     * 【核心】：
     * 递归，不断压栈再不断出栈。是自上而下解决问题，等待下面返回上来的结果。
     * 动态规划是自下而上解决问题，从已知的 case 出发，存储前面的状态，迭代出最后的结果。
     * 动态规划就是想办法不用递归，利用递推关系用“填表格”的方式顺序计算。每个 dp 项的值其实等于一个递归子调用的结果（递归子问题的解）。
     *
     * 链接：https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/shou-hui-tu-jie-dfsdi-gui-ji-yi-hua-di-gui-dong-ta/
     */


    /**
     * 递归（记忆化搜索）
     */
    private int[] memo;

    public int translateNum(int num) {
        String str = String.valueOf(num);
        int n = str.length();
        memo = new int[n + 1];
        memo[n - 1] = 1;
        memo[n] = 1;
        return dfs(str, 0);
    }

    // 「当前指针位置到末尾的数字」的翻译方法数
    private int dfs(String str, int index) {
        if (index >= str.length() - 1) {
            return 1;
        }

        if (memo[index] > 0) {
            return memo[index];
        }

        int tmp = str.charAt(index) + str.charAt(index + 1);
        if (tmp >= 10 && tmp <= 25) {
            memo[index] = dfs(str, index + 1) + dfs(str, index + 2);
        } else {
            memo[index] = dfs(str, index + 1);
        }
        return memo[index];
    }


    /**
     * 题解：https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/mian-shi-ti-46-ba-shu-zi-fan-yi-cheng-zi-fu-chua-6/
     */
    public int translateNum_dp(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }


}
