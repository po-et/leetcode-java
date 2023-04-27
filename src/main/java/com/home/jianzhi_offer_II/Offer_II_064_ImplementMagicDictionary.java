package com.home.jianzhi_offer_II;

/**
 * 剑指 Offer II 064. 神奇的字典
 *
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同。
 * 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于已构建的神奇字典中。
 *
 * 实现 MagicDictionary 类：
 *
 * MagicDictionary() 初始化对象
 * void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
 * bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
 *
 *
 * 示例：
 *
 * 输入
 * inputs = ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
 * inputs = [[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
 * 输出
 * [null, null, false, true, false, false]
 *
 * 解释
 * MagicDictionary magicDictionary = new MagicDictionary();
 * magicDictionary.buildDict(["hello", "leetcode"]);
 * magicDictionary.search("hello"); // 返回 False
 * magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
 * magicDictionary.search("hell"); // 返回 False
 * magicDictionary.search("leetcoded"); // 返回 False
 *
 * 注意：本题与主站 676 题相同： https://leetcode-cn.com/problems/implement-magic-dictionary/
 *
 * @see <a href="https://leetcode.cn/problems/US1pGT/" />
 * @author Poet
 * @date 2023/4/2
 */
public class Offer_II_064_ImplementMagicDictionary {

    /**
     * 方法一：枚举每个字典中的字符串并判断（暴力解法）
     */
    class MagicDictionary {

        private String[] words;

        /** Initialize your data structure here. */
        public MagicDictionary() {
        }

        public void buildDict(String[] dictionary) {
            words = dictionary;
        }

        public boolean search(String searchWord) {
            for (String word : words) {
                if (word.length() != searchWord.length()) {
                    continue;
                }
                int diff = 0;
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) != searchWord.charAt(i)) {
                        diff++;
                    }
                    if (diff > 1) {
                        return false;
                    }
                }
                if (diff == 1) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 方法二：前缀树
     */
    class Trie {
        Trie[] children;
        boolean isEnd;
        public Trie() {
            this.children = new Trie[26];
            this.isEnd = false;
        }
    }

    class MagicDictionary_trie {
        private Trie root;

        public MagicDictionary_trie() {
            root = new Trie();
        }

        public void buildDict(String[] dictionary) {
            for (String word : dictionary) {
                Trie cur = root;
                for (int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    int index = ch - 'a';
                    if (cur.children[index] == null) {
                        cur.children[index] = new Trie();
                    }
                    cur = cur.children[index];
                }
                cur.isEnd = true;
            }
        }

        public boolean search(String searchWord) {
            return dfs(searchWord, root, 0, false);
        }

        private boolean dfs(String searchWord, Trie node, int pos, boolean isModified) {
            if (pos == searchWord.length()) {
                return node.isEnd && isModified;
            }

            int index = searchWord.charAt(pos) - 'a';
            if (node.children[index] != null) {
                if (dfs(searchWord, node.children[index], pos + 1, isModified)) {
                    return true;
                }
            }

            if (!isModified) {
                for (int i = 0; i < 26; i++) {
                    if (i != index && node.children[i] != null) {
                        if (dfs(searchWord, node.children[i], pos + 1, true)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
}
