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

  public static int maxProfit2(int[] prices) {
    /**
     * 方法1的优化
     * 由方法1可以看出当天利润只和前一天相关
     * 所以实际上使用一个变量保存不持有的最大利润，另一个变量保存持有的最大利润即可
     */
    int length = prices.length;
    if (prices == null || length < 2) {
      return 0;
    }
    /**
     * 初始化条件第一天是否持有
     * hold: -prices[0]
     * noHold: 0
     * 在遍历过程中，实际上hold和notHeld可以看做是昨天的收益来使用
     */
    int hold = -prices[0];
    int notHeld = 0;
    for (int i = 1; i < length; i++) {
      hold = Math.max(hold, notHeld - prices[i]);
      notHeld = Math.max(notHeld, hold + prices[i]);
    }
    return notHeld;
  }

  public static int maxProfit3(int[] prices) {
    /**
     * 贪心算法
     * 今日股价 - 昨日股价一共有三种情况 0 负数 正数
     * 我们要求最大利润，则只加正数即可
     * 此方法只能求出最大利润，并不能反映真实的交易过程
     */
    int length = prices.length;
    if (prices == null || length < 2) {
      return 0;
    }
    int profit = 0;
    for (int i = 1; i < prices.length; i++) {
      profit += Math.max(0, prices[i] - prices[i - 1]);
    }
    return profit;
  }

  public static void main(String[] args) {
    System.out.println(maxProfit(new int[]{1,2,3,4,5}));
    System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    System.out.println(maxProfit2(new int[]{1,2,3,4,5}));
    System.out.println(maxProfit2(new int[]{7,1,5,3,6,4}));
    System.out.println(maxProfit3(new int[]{1,2,3,4,5}));
    System.out.println(maxProfit3(new int[]{7,1,5,3,6,4}));
  }
}
