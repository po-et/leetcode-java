package com.home.leetcode.hard;

//import org.apache.commons.lang3.tuple.Pair;

/**
 * 854. K-Similar Strings (相似度为 K 的字符串)
 *
 * Strings s1 and s2 are k-similar (for some non-negative integer k) if we can swap the positions of two letters in s1 exactly k times so that the resulting string equals s2.
 *
 * Given two anagrams s1 and s2, return the smallest k for which s1 and s2 are k-similar.
 *
 * Example 1:
 * Input: s1 = "ab", s2 = "ba"
 * Output: 1
 *
 * Example 2:
 * Input: s1 = "abc", s2 = "bca"
 * Output: 2
 *
 * Constraints:
 *  - 1 <= s1.length <= 20
 *  - s2.length == s1.length
 *  - s1 and s2 contain only lowercase letters from the set {'a', 'b', 'c', 'd', 'e', 'f'}.
 *  - s2 is an anagram of s1.
 *
 * @see <a href="https://leetcode.cn/problems/k-similar-strings/" />
 * @author Poet
 * @date 2022/9/21
 */
public class LC_854_K_SimilarStrings {

    // 直接参考答案

    /**
     * 方法一：广度优先搜索
     * 思路：枚举所有可能的交换方案，在搜索时进行减枝从而提高搜索效率，最终找到最小的交换次数
     */
//    public int kSimilarity(String s1, String s2) {
//        int n = s1.length();
//        Queue<Pair<String, Integer>> queue = new ArrayDeque<Pair<String, Integer>>();
//        Set<String> visit = new HashSet<>();
//        queue.offer(new Pair<String, Integer>(s1, 0));
//        visit.add(s1);
//        int step = 0;
//        while (!queue.isEmpty()) {
//            int sz = queue.size();
//            for (int i = 0; i < sz; i++) {
//                Pair<String, Integer> pair = queue.poll();
//                String cur = pair.getKey();
//                int pos = pair.getValue();
//                if (cur.equals(s2)) {
//                    return step;
//                }
//                while (pos < n && cur.charAt(pos) == s2.charAt(pos)) {
//                    pos++;
//                }
//                for (int j = pos + 1; j < n; j++) {
//                    if (s2.charAt(j) == cur.charAt(j)) {
//                        continue;
//                    }
//                    if (s2.charAt(pos) == cur.charAt(j)) {
//                        String next = swap(cur, pos, j);
//                        if (!visit.contains(next)) {
//                            visit.add(next);
//                            queue.offer(new Pair<String, Integer>(next, pos + 1));
//                        }
//                    }
//                }
//            }
//            step++;
//        }
//        return step;
//    }
//
//    public String swap(String cur, int i, int j) {
//        char[] arr = cur.toCharArray();
//        char c = arr[i];
//        arr[i] = arr[j];
//        arr[j] = c;
//        return new String(arr);
//    }

}
