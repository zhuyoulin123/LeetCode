package com.zyl.demo.array;

/**
 * @author zhuyoulin
 * @program IntelliJ IDEA
 * @description 第一个错误版本题目
 * @create 2022-02-24 17:40
 **/
public class FirstErrorVersion {
  public int firstBadVersion(int n) {
    /**
     * 二分法解:
     * 先取得中间值调用相关api
     * 如果返回true 则范围在0 - 中间 [0 - mid]
     * 如果返回false 则范围在中间 - n (mid - n]
     */
    int start = 1;
    while (start < n) {
      int mid = start + (n - start) / 2;
      if (/*isBadVersion(mid)*/true) {
        n = mid;
      } else {
        start = mid + 1;
      }
    }
    return n;
  }
}
