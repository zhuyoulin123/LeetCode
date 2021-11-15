package com.zyl.demo.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuyoulin
 * @program LeetCode
 * @description 字符串中第一个唯一字符
 * @create 2021-11-15 22:30
 **/
public class FirstUniqChar {
  public static int firstUniqChar (String s) {
    /**
     * 先遍历统计字符出现次数
     * 再遍历找到只出现一次的那个数
     */
    int[] res = new int[26];
    char[] chars = s.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      res[chars[i] - 'a'] ++;
    }

    for (int i= 0; i < s.length(); i++) {
      if (res[chars[i] - 'a'] == 1) {
        return i;
      }
    }
    return -1;
  }

  public static int firstUniqChar2 (String s) {
    /**
     * 哈希表
     * 先遍历统计字符出现次数用哈希表存储起来
     * 再遍历找到只出现一次的那个数
     */
    Map<Character, Integer> count = new HashMap<>(s.length());
    char[] chars = s.toCharArray();
    for (char theChar : chars) {
      count.put(theChar, count.getOrDefault(theChar, 0) + 1);
    }
    for (int i = 0; i < s.length(); i++) {
      if (count.get(chars[i]) == 1) {
        return i;
      }
    }
    return -1;
  }

  public static int firstUniqChar3 (String s) {
    /**
     * 使用Java Api解法
     * 一个从前查找，一个从后查找，如果下标相等，则就是该值
     */
    char[] chars = s.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      if (s.indexOf(chars[i]) == s.lastIndexOf(chars[i])) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(firstUniqChar("legend"));
  }
}
