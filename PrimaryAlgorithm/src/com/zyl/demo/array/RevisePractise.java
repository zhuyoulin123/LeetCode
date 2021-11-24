package com.zyl.demo.array;

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
}
