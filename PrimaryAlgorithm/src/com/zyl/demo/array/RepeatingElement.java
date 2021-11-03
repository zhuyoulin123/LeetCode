package com.zyl.demo.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhuyoulin
 * @program LeetCode
 * @description 存在重复元素
 * @create 2021-11-03 22:58
 **/
public class RepeatingElement {
  public static boolean containsDuplicate(int[] nums) {
    /**
     * 排序之后两两比较即可
     */
    Arrays.sort(nums);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i -1]) {
        return true;
      }
    }
    return false;
  }

  public static boolean containsDuplicate2(int[] nums) {
    /**
     * 使用哈希表无法重复的特点
     */
    Set numsSet = new HashSet();
    for (int i = 0; i < nums.length; i++) {
      if (!numsSet.add(nums[i])) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(containsDuplicate(new int[]{1,1,2,3,4}));
    System.out.println(containsDuplicate(new int[]{2,4,2,3,4}));
    System.out.println(containsDuplicate(new int[]{1,5,2,3,4}));
    System.out.println(containsDuplicate2(new int[]{1,1,2,3,4}));
    System.out.println(containsDuplicate2(new int[]{2,4,2,3,4}));
    System.out.println(containsDuplicate2(new int[]{1,5,2,3,4}));
  }
}
