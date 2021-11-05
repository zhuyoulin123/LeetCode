package com.zyl.demo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhuyoulin
 * @program LeetCode
 * @description 两个数组的交集
 * @create 2021-11-05 22:24
 **/
public class IntersectionArrays {
  public static int[] intersect(int[] nums1, int[] nums2) {
    /**
     * 排序加双指针方法解决
     * 先将两个数组排序
     * 两个指针分别从两个数组的0开始遍历数组并比较大小
     * 比较大小有三种情况:
     * 相等: 两个指针均向前移动一位，并且将该值放入最终结果中
     * 小于另一值的指针向右移动一位，继续比较
     */
    List<Integer> nums3 = new ArrayList<>();
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int i = 0;
    int j = 0;
    while (i < nums1.length && j < nums2.length) {
      int iNum = nums1[i];
      int jNum = nums2[j];
      if (iNum > jNum) {
        j++;
      } else if (iNum < jNum){
        i++;
      } else {
        i++;
        j++;
        nums3.add(iNum);
      }
    }
    int index = 0;
    int[] res = new int[nums3.size()];
    for (int k = 0; k < nums3.size(); k++) {
      res[index++] = nums3.get(k);
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(intersect(new int[]{1,2,2,3,6,4,5}, new int[]{2,2,3}));
  }
}
