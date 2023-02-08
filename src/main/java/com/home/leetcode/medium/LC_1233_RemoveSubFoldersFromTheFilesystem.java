package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1233. Remove Sub-Folders from the Filesystem (删除子文件夹)
 *
 * Given a list of folders folder, return the folders after removing all sub-folders in those folders. You may return the answer in any order.
 *
 * If a folder[i] is located within another folder[j], it is called a sub-folder of it.
 *
 * The format of a path is one or more concatenated strings of the form: '/' followed by one or more lowercase English letters.
 *
 * For example, "/leetcode" and "/leetcode/problems" are valid paths while an empty string and "/" are not.
 *
 * Example 1:
 * Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
 * Output: ["/a","/c/d","/c/f"]
 * Explanation: Folders "/a/b" is a subfolder of "/a" and "/c/d/e" is inside of folder "/c/d" in our filesystem.
 *
 * Example 2:
 * Input: folder = ["/a","/a/b/c","/a/b/d"]
 * Output: ["/a"]
 * Explanation: Folders "/a/b/c" and "/a/b/d" will be removed because they are subfolders of "/a".
 *
 * Example 3:
 * Input: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
 * Output: ["/a/b/c","/a/b/ca","/a/b/d"]
 *
 * @see <a href="https://leetcode.cn/problems/remove-sub-folders-from-the-filesystem/" />
 * @author Poet
 * @date 2023/2/8
 */
public class LC_1233_RemoveSubFoldersFromTheFilesystem {

    // 参考答案
    
    /**
     * 方法一：排序
     */
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> res = new ArrayList<>();
        res.add(folder[0]);

        for (int i = 1; i < folder.length; i++) {
            int pre = res.get(res.size() - 1).length();
            if (!(pre < folder[i].length()
                    && res.get(res.size() - 1).equals(folder[i].substring(0, pre))
                    && folder[i].charAt(pre) == '/')) {
                res.add(folder[i]);
            }
        }
        return res;
    }

    /**
     * 方法二：字典树
     */

}
