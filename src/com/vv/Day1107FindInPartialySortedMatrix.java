package com.vv;

/**
 * @author ShenZhenWei
 * @date 2020/11/7
 *
 *在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 *
 *
 * https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&&tqId=11154&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * 剑指offer 48页
 */
public class Day1107FindInPartialySortedMatrix {
    public static void main(String[] args) {
        int target=1;
        int[][] array={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        boolean isFind=Find(target,array);
        System.out.println(isFind);
    }

    public static boolean Find(int target, int[][] array) {
        int row=0;
        int rows=array[0].length;
        int columns=array.length;
        int column=columns -1;
        while(row<rows && column>=0){
            if(target==array[row][column]){
                return true;
            }else if(target>array[row][column]){
                row++;
            }else if (target <array[row][column]){
                column--;
            }
        }

        return false;
    }
}

