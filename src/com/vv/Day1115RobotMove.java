package com.vv;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2020/11/15
 */
class Day1115RobotMove {
    private static boolean[][] vist;

    public static void main(String[] args) {
        System.out.println(movingCount(1, 2, 1));
    }


    public static int movingCount(int m, int n, int k) {
        //广度优先+回溯
        int resultNum = 0;
        vist = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //递归参数：坐标 m n k 是否已经被遍历过
                return dfs(i, j, m, n, k, vist);
            }
        }
        return resultNum;

    }


    public static int dfs(int i, int j, int m, int n, int k, boolean[][] isVist) {
        /**
         * 1 return 0
         *      - 当前坐标越界
         *      - sum[i]+sum[j]>k
         *      - 数据被访问过
         * 2 return ++
         *      esle
         */

        if (i < 0 || i >= m || j < 0 || j >= n || sumCount(i, j) > k || vist[i][j]) {
            return 0;
        }

        vist[i][j] = true;
        return 1 +
                //向左
                dfs(i - 1, j, m, n, k, vist) +
                //向右
                dfs(i + 1, j, m, n, k, vist) +
                //向上
                dfs(i, j - 1, m, n, k, vist) +
                //向下
                dfs(i, j + 1, m, n, k, vist);
    }


    public static int sumCount(int i, int j) {
        return sum(i) + sum(j);
    }

    public static int sum(int num) {
        int sumNum = 0;
        while (num != 0) {
            sumNum += num % 10;
            num = num / 10;
        }
        return sumNum;
    }


}
