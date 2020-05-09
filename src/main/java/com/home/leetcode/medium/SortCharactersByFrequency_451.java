package com.home.leetcode.medium;

import java.util.*;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 *
 *
 * @see <a href="https://leetcode.com/problems/sort-characters-by-frequency/" />
 * @author Poet
 * @date 2020/4/18
 */
public class SortCharactersByFrequency_451 {

    public static void main(String[] args) {
        SortCharactersByFrequency_451 solution = new SortCharactersByFrequency_451();
        String input = "tree";
        System.out.println(solution.frequencySort(input));
        System.out.println(solution.frequencySort2(input));
    }

    /**
     * 二维数组
     */
    public String frequencySort(String s) {
        int[][] freq = new int[128][2];
        for (char ch : s.toCharArray()) {
            freq[ch][0] = ch;
            freq[ch][1] ++;
        }

        Arrays.sort(freq, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < freq.length; i++) {
            for (int j = 0; j < freq[i][1]; j++) {
                ret.append((char)freq[i][0]);
                
            }
        }
        return ret.toString();
    }

    /**
     * HashMap
     */
    public String frequencySort2(String s) {
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        StringBuilder ret = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                ret.append(entry.getKey());
            }
        }
        return ret.toString();
    }

}
