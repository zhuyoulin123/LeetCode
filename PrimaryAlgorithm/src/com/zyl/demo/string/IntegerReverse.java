package com.zyl.demo.string;

/**
 * @author zhuyoulin
 * @program LeetCode
 * @description 整数反转
 * @create 2021-11-11 22:56
 **/
public class IntegerReverse {
  public static int reverse (int x) {
    /**
     * 以1234为例进行推导, 设结果为res
     * res = 0 * 10 + 1234 % 10 --- 4
     * res = 4 * 10 + (1234 / 10) % 10 --- 43
     * res = 43 * 10 + (1234 / 100) % 10 --- 432
     * res = 432 * 10 + (1234 / 1000) % 10 --- 4321
     * 所以:
     * res = res * 10 + x % 10;
     * x / 10;
     */
    long res = 0;
    while (x != 0) {
      res = res * 10 + x % 10;
      x /= 10;
    }

    // 这一步强转int类型，如果长度超过int则返回0
    return (int) res == res ? (int) res : 0;
  }

  public static void main(String[] args) {
    System.out.println(reverse(2147483647));
  }
}
