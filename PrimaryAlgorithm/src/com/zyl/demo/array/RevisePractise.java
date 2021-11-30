package com.zyl.demo.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhuyoulin
 * @program IntelliJ IDEA
 * @description 复习练习1
 * @create 2021-11-24 10:36
 **/
public class RevisePractise {
  /**
   * 买股票的最佳时机
   */
  public static int maxProfit(int[] prices) {
    if (prices == null || prices.length < 2) {
      return 0;
    }
    int[][] days = new int[prices.length][2];
    days[0][0] = 0;
    days[0][1] = -prices[0];
    for (int i = 1; i < prices.length; i++) {
      days[i][0] = Math.max(days[i-1][0], days[i-1][1] + prices[i]);
      days[i][1] = Math.max(days[i-1][1], days[i-1][0] - prices[i]);
    }
    return days[prices.length - 1][0];
  }

  public static void main(String[] args) {
    System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    System.out.println(maxProfit(new int[]{1,2,3,4,5}));
  }

  /**
   * 买股票的最佳时机
   */
  public static int maxProfit2(int[] prices) {
    if (prices == null || prices.length < 2) {
      return 0;
    }
    int res = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      res += Math.max(prices[i + 1] - prices[i], 0);
    }
    return res;
  }

  /**
   * 只出现了一次的数字 (哈希解法)
   * @param nums 数组
   * @return 返回的结果
   */
  public int singleNumber(int[] nums) {
    // 声明一个Set，利用Set中元素无法重复的特性
    Set<Integer> res = new HashSet<>();
    // 遍历数组，当把元素添加进set中时，如果返回false，则说明元素已经存在
    for (int num : nums) {
      if (!res.add(num)) {
        // 当该元素已经存在时，将其remove
        res.remove(num);
      }
    }
    // 最后set中存在的值就是结果
    return (int) res.toArray()[0];
  }

  /**
   * 只出现了一次的数字 (位运算解法)
   * @param nums
   * @return
   */
  public int singleNumber2(int[] nums) {
    /**
     * 1. 一个非0数与0异或结果为自己
     * 2. 0和0异或结果为0
     * 3. 异或运算满足交换律和结合律
     *
     * 假设数组为[a, a, b, c, b, d, c]
     * 有: a^a^b^c^b^d^c = (a^a)^(b^b)^(c^c)^(d) = 0^0^0^d = d
     *
     * 所以该题的结果为num中所有元素异或的结果
     */
    int res = 0;
    for (int num : nums) {
      res ^= num;
    }
    return res;
  }

  /**
   * 加一
   * @param digits 数组
   * @return 结果
   */
  public int[] plusOne(int[] digits) {
    /**
     * 遍历数组，当该位置上的值不为9时直接加1
     * 当该位置上当值为9时，往数组下标为
     */
    for (int i = digits.length; i > 0; i--) {
      if (digits[i-1] != 9) {
        digits[i-1] += 1;
        return digits;
      }
      digits[i-1] = 0;
    }
    int[] res = new int[digits.length+1];
    res[0] = 1;
    return res;
  }
}
