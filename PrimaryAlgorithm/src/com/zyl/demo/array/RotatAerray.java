package com.zyl.demo.array;

/**
 * @author zhuyoulin
 * @program LeetCode
 * @description 旋转数组
 * @create 2021-11-01 23:07
 **/
public class RotatAerray {
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

  public static void main(String[] args) {
    rotate(new int[]{1,2,3,4,5,6,7}, 3);
  }
}
