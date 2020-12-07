package com.vv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 字节题库
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2020/12/7
 */
class Day1207MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    public static int[][] merge(int[][] intervals) {
        // 1. 按照区间左边的值进行升序排列
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // 2. 初始化 outputs, 用于存储合并之后区间结果的动态数组
        ArrayList<int[]> outputs = new ArrayList<int[]>();
        // 3. 遍历处理每一个区间
        for (int i = 0; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            if (outputs.isEmpty()) {
                outputs.add(currInterval);
            } else { // 判断是否有重叠，有的话则合并
                int[] outputsLastInterval = outputs.get(outputs.size() - 1);
                int outputLastRight = outputsLastInterval[1];
                int currLeft = currInterval[0];
                if (outputLastRight < currLeft) { // 没有重叠
                    outputs.add(currInterval);
                } else { // 重叠，合并
                    int currRight = currInterval[1];
                    outputsLastInterval[1] = Math.max(outputLastRight, currRight);
                }
            }
        }
        return outputs.toArray(new int[outputs.size()][]);
    }

}
