package com.home.jianzhi_offer_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 082. 含有重复元素集合的组合
 *
 * 给定一个可能有重复数字的整数数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。
 *
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 *     [
 *       [1,1,6],
 *       [1,2,5],
 *       [1,7],
 *       [2,6]
 *     ]
 *
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 *     [
 *       [1,2,2],
 *       [5]
 *     ]
 *
 * 注意：本题与主站 40 题相同： https://leetcode-cn.com/problems/combination-sum-ii/
 *
 * @see <a href="https://leetcode.cn/problems/4sjJUc/" />
 * @author Poet
 * @date 2023/7/10
 */
public class Offer_II_081_CombinationSum_ii {

    /**
     * 方法：递归 + 回溯
     */
    List<int[]> freq = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> sequence = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        for (int num : candidates) {
            int size = freq.size();
            if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                freq.add(new int[]{num, 1});
            } else {
                ++freq.get(size - 1)[1];
            }
        }

        dfs(0, target);
        return res;
    }

    public void dfs(int pos, int rest) {
        if (rest == 0) {
            res.add(new ArrayList<>(sequence));
            return;
        }
        if (pos == freq.size() || rest < freq.get(pos)[0]) {
            return;
        }

        dfs(pos + 1, rest);

        int most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
        for (int i = 1; i <= most; ++i) {
            sequence.add(freq.get(pos)[0]);
            dfs(pos + 1, rest - i * freq.get(pos)[0]);
        }
        for (int i = 1; i <= most; ++i) {
            sequence.remove(sequence.size() - 1);
        }
    }

}
