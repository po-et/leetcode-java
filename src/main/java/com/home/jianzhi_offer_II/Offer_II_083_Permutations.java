package com.home.jianzhi_offer_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 剑指 Offer II 083. 没有重复元素集合的全排列
 *
 * 给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 * 注意：本题与主站 46 题相同：https://leetcode-cn.com/problems/permutations/
 *
 * @see <a href="https://leetcode.cn/problems/VvJkup/" />
 * @author Poet
 * @date 2023/7/10
 */
public class Offer_II_083_Permutations {

    /*
      【回溯法】：一种通过探索所有可能的候选解来找出所有的解的算法。
       如果候选解被确认不是一个解（或者至少不是最后一个解），回溯算法会通过在上一步进行一些变化抛弃该解，即回溯并且再次尝试。
     */

    /**
     * 方法：回溯
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<>(output));
        }

        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

}
