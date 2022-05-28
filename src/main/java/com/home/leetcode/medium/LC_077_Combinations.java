package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. Combinations
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4], [3,4], [2,3], [1,2], [1,3], [1,4],
 * ]
 *
 * @see <a href="https://leetcode.cn/problems/combinations/" />
 * @author Poet
 * @date 2020/6/6
 */
public class LC_077_Combinations {

    private List<List<Integer>> res;

    /**
     * 回溯法（liuyubo讲解）
     */
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if (n <= 0 || k <= 0 || k > n)
            return res;

        LinkedList<Integer> c = new LinkedList<>();
        generateCombination(n, k, 1, c);
//        generateCombination_better(n, k, 1, c);

        return res;
    }

    // 求解C(n,k), 当前已经找到的组合存储在c中，需要从start开始搜索新的元素
    private void generateCombination(int n, int k, int start, LinkedList<Integer> c) {
        if (c.size() == k) {
            res.add(new ArrayList<>(c));
            return;
        }

        for (int i = start; i <= n; i++) {
            c.addLast(i);
            generateCombination(n, k, i + 1, c);
            c.removeLast();
        }
    }


    /**
     * 通过【剪枝】优化回溯算法
     */
    private void generateCombination_better(int n, int k, int start, LinkedList<Integer> c) {
        if (c.size() == k) {
            res.add(new ArrayList<>(c));
            return;
        }

        // 还有k - c.size()个空位，所以[i...n]中至少要有k-c.size()个元素
        // i最多为 n - (k-c.size()) + 1
        for (int i = start; i <= n - (k - c.size()) + 1; i++) {
            c.addLast(i);
            generateCombination(n, k, i + 1, c);
            c.removeLast();
        }
    }

}
