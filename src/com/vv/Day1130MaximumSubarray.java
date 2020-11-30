package com.vv;

/**
 * 字节题库
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2020/11/30
 */
class Day1130MaximumSubarray {
    public static void main(String[] args) {
        int[] a = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(a));
    }

    /**
     * 思路  ：如果当前的和加上当前的数字>当前数字，那么则累加
     * 如果当前和加上当前数字<=当前数字，则说明当前累加的和是无效的，所以需要将和移动到当前数字
     * 每次都比较和的大小
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int comp = nums[0];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > nums[i]) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            comp = Math.max(comp, sum);
        }
        return comp;
    }
}
