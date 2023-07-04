package com.home.jianzhi_offer_II;

/**
 * 剑指 Offer II 067. 最大的异或
 *
 * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 *
 * 示例 1：
 * 输入：nums = [3,10,5,25,2,8]
 * 输出：28
 * 解释：最大运算结果是 5 XOR 25 = 28.
 *
 * 示例 2：
 * 输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
 * 输出：127
 *
 * 注意：本题与主站 421 题相同： https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/
 *
 * @see <a href="https://leetcode.cn/problems/ms70jA/" />
 * @author Poet
 * @date 2023/4/3
 */
public class Offer_II_067_MaximumXorOfTwoNumbersInAnArray {

    // 直接参考答案

    class Solution {
        // 字典树的根节点
        Trie root = new Trie();
        // 最高位的二进制位编号为 30
        static final int HIGH_BIT = 30;

        public int findMaximumXOR(int[] nums) {
            int n = nums.length;
            int x = 0;
            for (int i = 1; i < n; ++i) {
                // 将 nums[i-1] 放入字典树，此时 nums[0 .. i-1] 都在字典树中
                add(nums[i - 1]);
                // 将 nums[i] 看作 ai，找出最大的 x 更新答案
                x = Math.max(x, check(nums[i]));
            }
            return x;
        }

        public void add(int num) {
            Trie cur = root;
            for (int k = HIGH_BIT; k >= 0; --k) {
                int bit = (num >> k) & 1;
                if (bit == 0) {
                    if (cur.left == null) {
                        cur.left = new Trie();
                    }
                    cur = cur.left;
                }
                else {
                    if (cur.right == null) {
                        cur.right = new Trie();
                    }
                    cur = cur.right;
                }
            }
        }

        public int check(int num) {
            Trie cur = root;
            int x = 0;
            for (int k = HIGH_BIT; k >= 0; --k) {
                int bit = (num >> k) & 1;
                if (bit == 0) {
                    // a_i 的第 k 个二进制位为 0，应当往表示 1 的子节点 right 走
                    if (cur.right != null) {
                        cur = cur.right;
                        x = x * 2 + 1;
                    } else {
                        cur = cur.left;
                        x = x * 2;
                    }
                } else {
                    // a_i 的第 k 个二进制位为 1，应当往表示 0 的子节点 left 走
                    if (cur.left != null) {
                        cur = cur.left;
                        x = x * 2 + 1;
                    } else {
                        cur = cur.right;
                        x = x * 2;
                    }
                }
            }
            return x;
        }
    }

    class Trie {
        // 左子树指向表示 0 的子节点
        Trie left = null;
        // 右子树指向表示 1 的子节点
        Trie right = null;
    }

}
