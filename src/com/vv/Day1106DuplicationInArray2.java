package com.vv;

/**
 * @author ShenZhenWei
 * @date 2020/11/6
 * <p>
 * <p>
 * 在一个长度为n+1的数组里的所有数字都在1~n的范围内，
 * 所以数组中至少有一个数字是重复的。请找出数组中任意一个重复的数字，
 * 但不能修改输入的数组。
 * 例如，如果输入长度为8的数组{2,3,5,4,3,2,6,7},
 * 那么对应的输出是重复的数字2或者3.
 * <p>
 * 来源：剑指offer 第42页
 * <p>
 * 输入：
 * [2,3,5,4,3,2,6,7]
 * 输出：2 或 3
 */
public class Day1106DuplicationInArray2 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 5, 4, 3, 2, 6, 7};
        int findNumber = findRepeatNumber(nums);
        System.out.println(findNumber);
    }

    public static int findRepeatNumber(int[] nums) {
        int findNumbser=-1;
        int start = 1;
        int end = nums.length - 1;
        while (end >= start) {
            int m = (end + start) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= start && nums[i] <= m) {
                    count++;
                }
            }
            if (count > (m-start+1)) {
                end=m;
            }else {
                start=m+1;
            }

            if (start==end){
                if (count>1){
                    return start;
                }else {
                    break;
                }
            }
        }
        return findNumbser;
    }
}
