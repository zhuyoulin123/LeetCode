package com.zyl.demo.array;

/**
 * @author zhuyoulin
 * @program LeetCode
 * @description 加一
 * @create 2021-11-08 23:30
 **/
public class PlusOne {
  public static int[] plusOne(int[] digits) {
    /**
     * 从后往前遍历，如果为9，那么将其置为1
     * 如果不为9，直接加1，并返回结果
     * 如果都为9，那么声明一个长度为length + 1的数组，将第一位置为1
     */
    int length = digits.length;
    for (int i = length - 1; i >= 0; i--) {
      // 如果等于9，将其置为0
      if (digits[i] == 9) {
        digits[i] = 0;
      } else {
        // 如果小于9，那么将其加1，并返回结果
        digits[i] += 1;
        return digits;
      }
    }
    // 最后一种可能全为9
    int[] temp = new int[length + 1];
    temp[0] = 1;
    return temp;
  }

  public static void main(String[] args) {
    plusOne(new int[]{9,9,9,9});
  }
}
