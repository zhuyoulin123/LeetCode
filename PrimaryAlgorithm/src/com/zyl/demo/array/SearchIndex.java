package com.zyl.demo.array;

/**
 * @author zhuyoulin
 * @program IntelliJ IDEA
 * @description 二分查找
 * @create 2022-02-15 10:33
 **/
public class SearchIndex {
  public static int search (int[] nums, int target) {
    int result = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        return i;
      }
    }
    return result;
  }

  public static int binarySearch (int[] nums, int target) {
    /**
     * 二分法解:
     * 对于目标值target
     * 找到数组中下标中间值 mid, 最大下标max, 最小下标min
     * 当mid = target时 此时小标为结果
     * 当mid < target时 min = mid
     * 当mid > target时 max = mid
     */
    int min = 0, max = nums.length - 1;
    while (min <= max) {
      int mid = (max - min) / 2 + min;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target){
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int res = binarySearch(new int[]{1, 4, 6, 9, 11, 15}, 15);
    System.out.println(res);
  }
}
