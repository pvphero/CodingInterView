package com.vv;

/**
 * 33. 搜索旋转排序数组
 * 给你一个整数数组 nums ，和一个整数 target 。
 * <p>
 * 该整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
 * <p>
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 *  
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [1], target = 0
 * 输出：-1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2020/12/6
 */
public class Day1206SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] a = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(a, 0));
        System.out.println(search(a, 3));
        System.out.println(search(a, 2));
        int[] b = new int[]{1};
        System.out.println(search(b, 0));

    }

    /**
     * 思路：遇到排序，查找 第一反应就是二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        //定义两个指针
        int low = 0;
        int heigh = nums.length - 1;
        int mid = -1;
        while (low <= heigh) {
            mid = (low + heigh) / 2;

            if (target == nums[mid]) {
                return mid;
            }

            if (nums[0] <= nums[mid]) {
                //说明左边是有序的
                if (target >= nums[0] && target <= nums[mid]) {
                    //说明target在mid 的左边。再缩小左边的查找范围
                    heigh = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                //说明右边有序
                if (target >= nums[mid] && target <= nums[heigh]) {
                    //说明在mid的右边，缩短右边的查找范围
                    low = mid + 1;
                } else {
                    heigh = mid - 1;
                }
            }
        }
        return -1;
    }
}
