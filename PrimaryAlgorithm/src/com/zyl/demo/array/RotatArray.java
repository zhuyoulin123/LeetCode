package com.zyl.demo.array;

/**
 * @author zhuyoulin
 * @program LeetCode
 * @description 旋转数组
 * @create 2021-11-01 23:07
 **/
public class RotatArray {
  public static void rotate(int[] nums, int k) {
    /**
     * 使用一个临时数组来保存原数组
     * 可以通过(i + k) % length来获取移动后的下标
     * 将移动后下标处的值替换为temp中对应的值
     * num[(i + k) % length] = temp[i]
     */
    int length = nums.length;
    int[] temp = new int[length];
    for (int j = 0; j < length; j++) {
      temp[(j+k) % length] = nums[j];
    }
    System.arraycopy(temp, 0, nums, 0, length);
  }

  public static void rotate2(int[] nums, int k) {
    /**
     * 解法二多次翻转
     * 基于事实: 当一个长度为n的数组右移k位后，尾部 k % n 的元素会被移到头部， 其余的元素会向右移 k % n的位置
     * 所以先翻转数组
     * 然后将[0, k % n -1]区间内的元素翻转
     * 再将[k % n, n-1]区间内的元素翻转
     * 即可得到最终答案
     */
    int length = nums.length;
    reverse(nums, 0, length - 1);
    reverse(nums, 0, k % length - 1);
    reverse(nums, k % length, length -1);
  }

  private static void reverse (int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }



  public static void main(String[] args) {
    rotate(new int[]{1,2,3,4,5,6,7}, 3);
    rotate2(new int[]{1,2,3,4,5,6,7}, 3);
  }
}
