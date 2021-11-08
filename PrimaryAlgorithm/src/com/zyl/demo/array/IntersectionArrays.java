package com.zyl.demo.array;

import java.util.*;

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

  public static int[] intersect2(int[] nums1, int[] nums2) {
    /**
     * 哈希表解法
     * 将数组中的值存到map中，键为数组中的值，值为该值出现的次数
     * 遍历另一个数组，如果该值在map中存在，则减少map相应键的值，并将其存入list中
     * 为了降低空间复杂度，我们优先遍历较短数组
     */
    if (nums1.length > nums2.length) {
      // 判断入参的长度，优先遍历较短数组
      return intersect2(nums2, nums1);
    }
    Map<Integer, Integer> numsMap = new HashMap(nums1.length);
    // 遍历较短数组，将值放入map中
    for (int num : nums1) {
      int count = numsMap.getOrDefault(num, 0) + 1;
      numsMap.put(num, count);
    }

    int[] resArray = new int[nums1.length];
    int index = 0;
    // 遍历数组2
    for (int num : nums2) {
      // 判断num值是否在数组中
      int count = numsMap.getOrDefault(num, 0);
      if (count > 0) {
        // 如果num在数组中，那么将其添加到结果数组中, index++会先执行赋值，之后再++
        resArray[index++] = num;
        count--;
        // 如果该值出现了不止一次，那么key对应的值减1
        if (count > 0) {
          numsMap.put(num, count);
        } else {
          numsMap.remove(num);
        }
      }
    }
    // 如果交集的数量小于nums1的长度，那么直接返回resArray，后面的项会补0，故只需截取[0, index]区间即可
    return Arrays.copyOfRange(resArray, 0, index);
  }

  public static void main(String[] args) {
    System.out.println(intersect(new int[]{1,2,2,3,6,4,5}, new int[]{2,2,3}));
    System.out.println(intersect2(new int[]{1,2,2,1}, new int[]{2,2}));
  }
}
