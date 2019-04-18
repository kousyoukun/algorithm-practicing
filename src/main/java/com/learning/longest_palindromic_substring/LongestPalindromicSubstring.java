package com.learning.longest_palindromic_substring;

import java.util.*;

/**
 * 最长回文子串
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcabcbb"));
    }

    /*private static String longestPalindrome(String str) {
        LinkedList<Character> list = new LinkedList<Character>();
        int n = str.length();
        int i, j; //中心点
        if (n % 2 != 0) {
            int mid = n / 2;
            i = j = mid;
        } else {
            int mid = n / 2;
            i = mid - 1;
            j = mid;
        }
        while (str.charAt(i) == str.charAt(j) && i >=0 && j < n) {
            if (i == j) {
                list.add(str.charAt(i--));
                j++;
            } else {
                list.addFirst(str.charAt(i--));
                list.addLast(str.charAt(j++));
            }
        }
        return list.toString();
    }*/

    private static String longestPalindrome(String str) {
        if (str == null || str.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < str.length(); i++) {
            int len1 = expandAroundCenter(str, i, i);
            int len2 = expandAroundCenter(str, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return str.substring(start, end + 1);
    }

    private static int expandAroundCenter(String str, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
