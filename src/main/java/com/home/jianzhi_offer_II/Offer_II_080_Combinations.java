package com.home.jianzhi_offer_II;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 080. 含有 k 个元素的组合
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例 1:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 示例 2:
 * 输入: n = 1, k = 1
 * 输出: [[1]]
 *
 * 注意：本题与主站 77 题相同： https://leetcode-cn.com/problems/combinations/
 *
 * @see <a href="https://leetcode.cn/problems/uUsW3B/" />
 * @author Poet
 * @date 2023/7/9
 */
public class Offer_II_080_Combinations {

    /**
     * 方法：回溯法
     */
    private int k;
    private final List<Integer> path = new ArrayList<>();
    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        dfs(n);
        return res;
    }

    private void dfs(int i) {
        int d = k - path.size(); // 还要选 d 个数
        if (d == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 不选 i
        if (i > d) dfs(i - 1);
        // 选 i
        path.add(i);
        dfs(i - 1);
        path.remove(path.size() - 1);
    }

}
