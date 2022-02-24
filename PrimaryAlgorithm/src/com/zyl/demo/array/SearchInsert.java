package com.zyl.demo.array;

/**
 * @author zhuyoulin
 * @program IntelliJ IDEA
 * @description 搜索插入位置
 * @create 2022-02-24 22:21
 **/
public class SearchInsert {
  public int searchInsert(int[] nums, int target) {
    /**
     * 二分法解:
     * 找到第一个比 target 大的下标即为答案
     */
    int start = 0;
    int length = nums.length - 1;
    while (start <= length) {
      int mid = start + (length - start) / 2;
      if (target > nums[mid]){
        start = mid + 1;
      } else {
        length = mid - 1;
      }
    }
    return start;
  }
}
