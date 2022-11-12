package com.home.leetcode.medium;

/**
 * 210. Course Schedule II
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 *
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 *
 * Example 2:
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 *
 * Example 3:
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 *
 * @see <a href="https://leetcode.cn/problems/course-schedule-ii/?envType=study-plan&id=leetcode_75_level_2&plan=leetcode_75&plan_progress=4iv1f0h" />
 * @author Poet
 * @date 2022/11/12
 */
public class LC_210_CourseSchedule_II {

    /**
     * 本题是一道经典的「拓扑排序」问题
     *
     * 「拓扑排序」是专门应用于有向图的算法
     */

    // solution: https://leetcode.cn/problems/course-schedule-ii/solution/tuo-bu-pai-xu-shen-du-you-xian-bian-li-python-dai-/
    public int[] findOrder(int numCourses, int[][] prerequisites) {


        return null;
    }
}
