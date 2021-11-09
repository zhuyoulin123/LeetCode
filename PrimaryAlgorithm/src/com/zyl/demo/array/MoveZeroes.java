package com.zyl.demo.array;

/**
 * @author zhuyoulin
 * @program LeetCode
 * @description 移动零
 * @create 2021-11-09 22:22
 **/
public class MoveZeroes {
  public static void moveZeroes(int[] nums) {
    /**
     * 双指针解法
     * 一个指针指向不为0的值操作(j)
     * 需要另一个值来记录0出现的次数(i)
     * 可以把j - i看作另一个指针，它指向第一个0的位置
     * 将j - i和j指向的值交换即可
     */
    int length = nums.length;
    int i = 0;
    for (int j = 0; j < length; j++) {
      if (nums[j] == 0) {
        i++;
      } else if (i != 0) {
        nums[j - i] = nums[j];
        nums[j] = 0;
      }
    }
  }

  public static void moveZeroes2(int[] nums) {
    /**
     * 向前挪解法
     * 为0的值不动
     * 非0的值向前移动
     * 最后将剩下的值置为0
     */
    if (nums == null || nums.length == 0) {
      return;
    }
    int length = nums.length;
    int index = 0;
    for (int i = 0; i < length; i++) {
      if (nums[i] != 0) {
        nums[index++] = nums[i];
      }
    }
    while(index < length) {
      nums[index++] = 0;
    }
  }

  public static void main(String[] args) {
    moveZeroes(new int[]{0, 1, 0, 3, 12, 0});
  }
}
