package com.zyl.demo.string;

import java.util.Locale;

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

  /**
   * 正则表达式解法
   *
   */
  public static boolean isPalindrome2(String s) {
    if (s == null || "".equals(s) || s.length() == 0) {
      return true;
    }
    // 使用正则表达式将除字母数字之外的值排除
    String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
    // 将得到的结果反转
    String reverseStr = new StringBuffer(actual).reverse().toString();
    // 最终返回两字符串比较的值
    return actual.equals(reverseStr);
  }

  /**
   * 双指针解法
   *
   */
  public static boolean isPalindrome3(String s) {
    if (s == null || "".equals(s) || s.length() == 0) {
      return true;
    }
    int length = s.length();
    // 使用正则表达式将除字母数字之外的值排除
    int left = 0, right = length - 1;
    while (left < right) {
      // 当当前下标字符不为字母或数字时，跳过该项
      while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
        left++;
      }
      while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
        right --;
      }
      if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
  }
}
