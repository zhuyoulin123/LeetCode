package com.zyl.demo.array;

/**
 * @author zhuyoulin
 * @program LeetCode
 * @description 删除排序数组中的重复项
 *              当nums=0时，返回0
 *              当nums不为0时，返回nums非重复项的个数
 * @create 2021-10-27 22:51
 **/
public class DelRepeat {
    public static int removeDuplicates(int[] nums) {
        /**
         * 双指针解法:
         * 快指针从1开始，慢指针从0开始
         * 快指针负责扫描整个数组，慢指针负责标记不同元素
         * 当快指针位置的值等于慢指针时，说明值相同，此时快指针继续遍历下一个位置
         * 当快指针位置的值不等于慢指针时，说明出现不同值的元素，此时将慢指针指向下一个位置，并将快指针的值赋给它
         * 最后返回慢指针的值+1
         */
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
        }
        return ++left;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2, 3, 4, 5, 6, 6, 6, 7, 8, 9, 9}));
    }
}
