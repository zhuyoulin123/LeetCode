package com.zyl.demo.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhuyoulin
 * @program LeetCode
 * @description 只出现一次的数字
 * @create 2021-11-04 22:50
 **/
public class AppearsOnce {
  public static int singleNumber(int[] nums) {
    /**
     * 使用set不能重复的特性
     * 将数组中元素添加到set中
     * 如果add时返回false，说明为重复元素，使用remove()移除
     * 最后set中剩余元素即为唯一数字
     */
    Set numSet = new HashSet();
    for (int num : nums) {
      if (!numSet.add(num)) {
        numSet.remove(num);
      }
    }
    return (int)numSet.toArray()[0];
  }

  public static int singleNumber2(int[] nums) {
    /**
     * 使用位运算
     * 任何数与自身做异或，结果是0
     * 任何数与0做异或，结果是自身
     * 异或运算满足交换律和结合律，即a^b^a = a^a^b = (a^a)^b = 0^b = b
     * 假设a为单独的数，使用交换律和结合律将相同的值两两异或，得到的结果都为0，最终a^0,结果为a
     * 故数组中所有元素的异或结果即为唯一的数字
     */
    int single = 0;
    for (int num : nums) {
      single ^= num;
    }
    return single;
  }

  public static void main(String[] args) {
    System.out.println(singleNumber(new int[]{1,2,2,1,3,4,4,5,5}));
    System.out.println(singleNumber2(new int[]{1,2,2,1,3,4,4,5,5}));
  }
}
