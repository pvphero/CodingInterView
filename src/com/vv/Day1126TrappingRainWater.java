package com.vv;

/**
 * 字节题库
 * 42. 接雨水
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2020/11/26
 */
public class Day1126TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    /**
     * 暴力解法
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        //思路：雨水的量=当前元素左边最大值 和 当前元素右边的最大值相比的最小值   -当前元素的值
        int leftMax = 0;
        int rightMax = 0;
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            leftMax = 0;
            rightMax = 0;
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int k = i; k < height.length; k++) {
                rightMax = Math.max(rightMax, height[k]);
            }
            sum += Math.min(leftMax, rightMax) - height[i];
        }
        return sum;
    }
}
