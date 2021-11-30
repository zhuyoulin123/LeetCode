package com.zyl.demo.string;

/**
 * @author zhuyoulin
 * @program IntelliJ IDEA
 * @description 复习练习1
 * @create 2021-11-30 23:01
 **/
public class RevisePractise {
  public static void reverseString(char[] s) {
    for (int left = 0, right = s.length - 1; right > left; left++, right--) {
      s[left] ^= s[right];
      s[right] ^= s[left];
      s[left] ^= s[right];
    }
  }

  public static void main(String[] args) {
    reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
  }
}
