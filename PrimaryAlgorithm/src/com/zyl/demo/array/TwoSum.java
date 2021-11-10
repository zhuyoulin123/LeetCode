package com.zyl.demo.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuyoulin
 * @program LeetCode
 * @description 两数之和
 * @create 2021-11-10 22:28
 **/
public class TwoSum {
  public static int[] twoSum(int[] nums, int target) {
    /**
     * 暴力破解法
     * 遍历数组找到和为target的组合
     * 这种解法效率很差
     */
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    return new int[]{-1};
  }

  public static int[] twoSum2(int[] nums, int target) {
    /**
     * 哈希值解法
     * 使用暴力破解法时找到target - x的时间复杂度过高
     * 该方法能够降低时间复杂度
     * 对于每一个x，先判断哈希表中是否有target - x，然后将x插入哈希表，这样可以保证x不与自己匹配
     */
    HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);
    for (int i = 0; i < nums.length; i++) {
      if (hashMap.containsKey(target - nums[i])) {
        return new int[]{hashMap.get(target - nums[i]), i};
      }
      hashMap.put(nums[i], i);
    }
    return  new int[]{0};
  }

  public static void main(String[] args) {
    twoSum(new int[]{1,2,4,5,6,7}, 13);
  }
}
