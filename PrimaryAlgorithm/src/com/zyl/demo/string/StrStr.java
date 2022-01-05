package com.zyl.demo.string;

/**
 * @author zhuyoulin
 * @program IntelliJ IDEA
 * @description 实现strStr()
 * @create 2022-01-05 22:07
 **/
public class StrStr {
  public static int strStr(String haystack, String needle) {
    // 如果为空，返回0
    if ("".equals(needle)) {
      return 0;
    }
    int i = 0, j = 0;

    /**
     * 双指针解法
     * 主字符串与子字符串依次比对
     * 相同则继续比对，不相同则主字符串从开始匹配的下一个位置继续匹配，子字符串则从头开始匹配
     */
    while (i < haystack.length() && j < needle.length()) {
      if (!(haystack.charAt(i) == needle.charAt(j))) {
        i = i - j + 1;
        j = 0;
      } else {
        i ++;
        j ++;
      }
      if (j == needle.length()) {
        return i - j;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(strStr("mississippi", "issip"));
  }
}
