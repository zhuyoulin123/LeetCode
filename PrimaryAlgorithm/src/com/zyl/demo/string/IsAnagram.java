package com.zyl.demo.string;

import java.util.Arrays;

/**
 * @author zhuyoulin
 * @program LeetCode
 * @description 有效的字母异位词
 * @create 2021-11-16 21:26
 **/
public class IsAnagram {
  public boolean isAnagram(String s, String t) {
    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
     * 先排序，排序之后相同的值会挨在一起，再比较数组是否一致即可
     */
    char[] sChar = s.toCharArray();
    char[] tChar = t.toCharArray();
    //对两个字符串中的字符进行排序
    Arrays.sort(sChar);
    Arrays.sort(tChar);
    return Arrays.equals(sChar, tChar);
  }
}
