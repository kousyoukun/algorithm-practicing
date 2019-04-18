package com.learning.longest_substring_without_repeating_characters;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    // 方法一
    /*private static int lengthOfLongestSubstring(String str) {
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                if (allUnique(str, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    private static boolean allUnique(String str, int start, int end) {
        Set<Character> set = new HashSet<Character>();
        for (int i = start; i < end; i++) {
            char c = str.charAt(i);
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }*/

    // 方法二
    private static int lengthOfLongestSubstring(String str) {
        int n = str.length();
        int i = 0, j = 0, ans = 0;
        Set<Character> set = new HashSet<Character>();
        while (i < n && j < n) {
            // 尝试增加窗口的长度
            if (!set.contains(str.charAt(j))) {
                set.add(str.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(str.charAt(i++));
            }
        }
        return ans;
    }
}
