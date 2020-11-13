package com.vv;

/**
 * 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[2,2,2,0,1]
 * 输出：0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2020/11/13
 */
public class Day1113MinNumberInRotatedArray {
    public static void main(String[] args) {
        int[] a = new int[]{3, 4, 5, 1, 2};
        System.out.print(minArray(a));

    }

    public static int minArray(int[] numbers) {
        int left = 0;
        int rigt = numbers.length - 1;
        int mid = -1;
        while (left < rigt) {
            mid = left + (rigt - left) / 2;
            if (numbers[mid] < numbers[rigt]) {
                rigt = mid;
            } else if (numbers[mid] == numbers[rigt]) {
                rigt--;
            } else if (numbers[mid] > numbers[rigt]) {
                left = mid + 1;
            }
        }
        return numbers[left];
    }


}
