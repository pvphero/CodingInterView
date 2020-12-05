package com.vv;

/**
 * 字节题库
 * <p>
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 * <p>
 * 输入：height = [1,1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * 示例 4：
 * <p>
 * 输入：height = [1,2,1]
 * 输出：2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Day1205TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    /**
     * 思路：根据题目要求，盛最多水的容器为两边最小宽度乘以距离，所以采用双指针
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int low = 0;
        int heigh = height.length - 1;
        int sum = 0;
        int newSum = 0;
        while (low < heigh) {
            sum = Math.min(height[low], height[heigh]) * (heigh - low);
            if (height[low] <= height[heigh]) {
                low++;
            } else {
                heigh--;
            }
            //用来存结果的最大值
            newSum = Math.max(newSum, sum);
        }
        return newSum;

    }
}
