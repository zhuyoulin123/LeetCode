package com.zyl.demo.string;

/**
 * @author zhuyoulin
 * @program LeetCode
 * @description 验证回文串
 * @create 2021-11-18 20:14
 **/
public class IsPalindrome {
  public static boolean isPalindrome(String s) {
    /**
     * 双指针解法
     * 左指针从前往后遍历
     * 右指针从后往前遍历
     * 如果不是数字或字母，需要过滤掉
     * 判断左右指针位置的值是否相等
     * 如果不想等返回false
     */
    if (s == null || "".equals(s) || s.length() == 0) {
      return true;
    }
    int length = s.length();
    s = s.toLowerCase();
    for (int i = 0, j = length - i - 1; i < j; i++, j--) {
      // 当不为字母和数字时，跳过
      while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
        i++;
      }
      while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
        j--;
      }
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
  }
}
