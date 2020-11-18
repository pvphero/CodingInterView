package com.vv;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2020/11/18
 */
public class Day1118ReorderArray {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] b = exchange(a);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + "");
        }

    }

    public static int[] exchange(int[] nums) {
        //思路：定义两个指针，一个从前往后找，一个从后往前找
        //如果P1遇到奇数，则跳过，直到遇到偶数，p2遇到奇数停止，遇到偶数跳过，然后两者交换

        int pre = 0;
        int last = nums.length - 1;
        int tmp;
        while (pre < last) {
            if (nums[pre] % 2 == 1) {
                pre++;
                continue;
            }
            if (nums[last] % 2 == 0) {
                last--;
                continue;
            }
            tmp = nums[pre];
            nums[pre] = nums[last];
            nums[last] = tmp;
        }
        return nums;
    }

}
