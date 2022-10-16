package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 886. Possible Bipartition （可能的二分法）
 *
 * We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.
 *
 * Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not
 * like the person labeled bi, return true if it is possible to split everyone into two groups in this way.
 *
 *
 * Example 1:
 * Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4] and group2 [2,3].
 *
 * Example 2:
 * Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 *
 * Example 3:
 * Input: n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 *
 * @see <a href="https://leetcode.cn/problems/possible-bipartition/" />
 * @author Poet
 * @date 2022/10/16
 */
public class LC_886_PossibleBipartition {

    /* ----- 这道题来自：第 97 场周赛 ----- */


    /**
     * 方法一：深度优先搜索
     *
     * 我们可以尝试用「染色法」来解决问题：假设第一组中的人是红色，第二组中的人为蓝色。我们依次遍历每一个人，如果当前的人没有被分组，就将其
     * 分到第一组（即染为红色），那么这个人不喜欢的人必须分到第二组中（染为蓝色）。然后任何新被分到第二组中的人，其不喜欢的人必须被分到第一组，
     * 依此类推。如果在染色的过程中存在冲突，就表示这个任务是不可能完成的，否则说明染色的过程有效（即存在合法的分组方案）。
     *
     */
    public boolean possibleBipartition_1(int n, int[][] dislikes) {
        return true;
    }

    /**
     * 方法二：广度优先搜索
     *
     * 同样也可以通过「广度优先搜索」来实现「方法一」中「染色法」的过程。
     */

    /**
     * 方法三：并查集
     *
     * solution: https://leetcode.cn/problems/possible-bipartition/solution/ke-neng-de-er-fen-fa-by-leetcode-solutio-guo7/
     */
    public boolean possibleBipartition_3(int n, int[][] dislikes) {
        int[] fa = new int[n + 1];
        Arrays.fill(fa, -1);
        List<Integer>[] g = new List[n + 1];
        for (int i = 0; i <= n; ++i) {
            g[i] = new ArrayList<>();
        }
        for (int[] p : dislikes) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < g[i].size(); ++j) {
                unit(g[i].get(0), g[i].get(j), fa);
                if (isconnect(i, g[i].get(j), fa)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void unit(int x, int y, int[] fa) {
        x = findFa(x, fa);
        y = findFa(y, fa);
        if (x == y) {
            return;
        }
        if (fa[x] < fa[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        fa[x] += fa[y];
        fa[y] = x;
    }

    public boolean isconnect(int x, int y, int[] fa) {
        x = findFa(x, fa);
        y = findFa(y, fa);
        return x == y;
    }

    public int findFa(int x, int[] fa) {
        return fa[x] < 0 ? x : (fa[x] = findFa(fa[x], fa));
    }

}
