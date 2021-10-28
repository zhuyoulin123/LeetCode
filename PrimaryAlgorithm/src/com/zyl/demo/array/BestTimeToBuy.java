package com.zyl.demo.array;

/**
 * @author zhuyoulin
 * @program LeetCode
 * @description 最佳时机买股票
 *              当prices为空或者prices的长度小于2时，返回0
 *              当prices不为空或长度大于等于2时，返回最高利润值
 * @create 2021-10-28 22:48
 **/
public class BestTimeToBuy {
  public static int maxProfit(int[] prices) {
    /**
     * 假定dp[i][0]为当天未持有股票最大利润
     * 假定dp[i][1]为当天持有股票最大利润
     *
     * 动态规划递推公式:
     * dp[i][0]=max(dp[i-1][1] + prices[i], dp[i-1][0])
     * dp[i][1]=max(dp[i-1][0] - prices[i], dp[i-1][1])
     *
     * 初始化条件就是第一天是否购买:
     * dp[0][0] = 0
     * dp[0][1] = -prices[0]
     *
     * 最后一天手中没有股票，利润应该最大故返回值为: dp[length][0]
     */
    int length = prices.length;
    if (prices == null || length < 2) {
      return 0;
    }
    int [][]dp = new int[length][2];
    dp[0][1] = -prices[0];
    dp[0][0] = 0;

    for (int i = 1; i < prices.length; i++) {
      dp[i][0] = Math.max(dp[i-1][1] + prices[i], dp[i-1][0]);
      dp[i][1] = Math.max(dp[i-1][0] - prices[i], dp[i-1][1]);
    }

    return dp[length-1][0];
  }

  public static void main(String[] args) {
    System.out.println(maxProfit(new int[]{1,2,3,4,5}));
    System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
  }
}
