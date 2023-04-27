package com.home.jianzhi_offer_II;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 066. 单词之和
 *
 * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
 *
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 *
 * 示例：
 *
 * 输入：
 * inputs = ["MapSum", "insert", "sum", "insert", "sum"]
 * inputs = [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：
 * [null, null, 3, null, 5]
 *
 * 解释：
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 *
 * 注意：本题与主站 677 题相同： https://leetcode-cn.com/problems/map-sum-pairs/
 *
 * @see <a href="https://leetcode.cn/problems/z1R5dt/" />
 * @author Poet
 * @date 2023/4/3
 */
public class Offer_II_066_MapSumPairs {

    /**
     * 方法一：暴力法
     */
    class MapSum_bruteForce {
        private Map<String, Integer> map;

        public MapSum_bruteForce() {
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            map.put(key, val);
        }

        public int sum(String prefix) {
            int res = 0;
            for (String key : map.keySet()) {
                if (key.startsWith(prefix)) {
                    res += map.get(key);
                }
            }
            return res;
        }
    }


    // 解法：https://leetcode.cn/problems/z1R5dt/solution/dan-ci-zhi-he-by-leetcode-solution-8vyo/
    class MapSum {
        Trie trie;
        public MapSum() {
            trie = new Trie();
        }

        public void insert(String key, int val) {
            Trie cur = trie;
            for (int i = 0; i < key.length(); i++) {
                char ch = key.charAt(i);
                int index = ch - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new Trie();
                }
                cur = cur.children[index];
            }
            cur.value = val;
        }

        public int sum(String prefix) {
            Trie cur = trie;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if (cur.children[index] == null) {
                    return 0;
                }
                cur = cur.children[index];
            }

            return dfs(cur, 0);
        }

        public int dfs(Trie node, int sum) {
            if (node == null) {
                return 0;
            }

            if (node.value > 0) {
                sum += node.value;
            }
            for (int i = 0; i < 26; i++) {
                sum += node.children[i] == null ? 0 : dfs(node.children[i], 0);
            }
            return sum;
        }
    }

    class Trie {
        Trie[] children;
        int value;
        public Trie() {
            children = new Trie[26];
            value = 0;
        }
    }


/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
}
