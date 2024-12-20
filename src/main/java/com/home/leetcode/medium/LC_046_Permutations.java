package com.home.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 46. Permutations (全排列)
 *
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * @see <a href="https://leetcode.cn/problems/permutations/" />
 * @author Poet
 * @date 2020/6/3
 */
public class LC_046_Permutations {

    /* ---
        回溯算法入门级详解 + 练习
        https://leetcode.cn/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
     --- */

    List<List<Integer>> res;
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        LinkedList<Integer> p = new LinkedList<>();
        used = new boolean[nums.length];

        generatePermutation(nums, 0, p);
        return res;
    }

    // p中保存了一个有index个元素的排列
    // 向这个排列的末尾添加第index+1个元素，获得一个有index+1个元素的排列
    private void generatePermutation(int[] nums, int index, LinkedList<Integer> p) {
        if (index == nums.length) {
            // 防止p更改，复制一份新的list
            res.add(new LinkedList<>(p));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                // 将nums[i]添加在p中
                p.addLast(nums[i]);
                used[i] = true;
                generatePermutation(nums, index + 1, p);

                // 回溯回去
                p.removeLast();
                used[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        LC_046_Permutations solution = new LC_046_Permutations();
        int[] nums = {1, 2, 3};
        System.out.println(solution.permute(nums));
    }

}
