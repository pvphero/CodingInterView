package com.vv;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2020/11/20
 */
public class Day1120TowNum {
    public static void main(String[] args) {
        int[] a = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(twoSum(a, target)[0] + "_" + twoSum(a, target)[1]);
        System.out.println(twoSum2(a, target)[0] + "_" + twoSum(a, target)[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static int[] twoSum2(int[] nums, int target) {
        //1.排序
        int[] tmpl = new int[nums.length];
        System.arraycopy(nums, 0, tmpl, 0, nums.length);
        Arrays.sort(nums);
        //2.定义两个指针
        int low = 0;
        int height = nums.length - 1;
        int sum = 0;
        int[] result = new int[2];
        int m = 0, n = 0, i = 0;
        while (low < height) {
            sum = nums[low] + nums[height];
            //3.定义 left用来保存  nums[low]的值，right 用来保存 nums[height]的值
            int left = nums[low];
            int right = nums[height];
            if (sum < target) {
                //4.优化 去掉重复的值
                while (low < height && nums[low] == left) {
                    low++;
                }
            } else if (sum > target) {
                while (low < height && nums[height] == right) {
                    height--;
                }
            } else if (sum == target) {
                m = low;
                n = height;
                while (low < height && nums[low] == left) {
                    low++;
                }
                while (low < height && nums[height] == right) {
                    height--;
                }
            }
        }

        for (i = 0; i < nums.length; i++) {
            if (tmpl[i] == nums[m]) {
                result[0] = i;
                break;
            }
        }

        for (int k = 0; k < nums.length; k++) {
            if (tmpl[k] == nums[n] && k != i) {
                result[1] = k;
                break;
            }
        }
        return result;

    }

}
