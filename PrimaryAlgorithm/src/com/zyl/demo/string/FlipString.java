package com.zyl.demo.string;

/**
 * @author zhuyoulin
 * @program LeetCode
 * @description 反转字符串
 * @create 2021-11-11 22:21
 **/
public class FlipString {
  public static void reverseString(char[] s) {
    /**
     * 双指针解法
     * 左指针从0开始。右指针从length - 1开始
     * 左指针和右指针指向的值交换
     * 当左指针 < 右指针 时，交换两个位置的值，并且左指针向右移一位，右指针向左移一位
     * 当右指针 <= 左指针时 (= 时 length 为奇数，< 时 length 为偶数) 直接返回结果
     */
    int n = s.length;
    for (int left = 0, right = n - 1; left < right; right--, left++) {
      if (left < right) {
        s[left] ^= s[right];
        s[right] ^= s[left];
        s[left] ^= s[right];
      }
    }
  }

  public static void main(String[] args) {
    reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
  }
}
