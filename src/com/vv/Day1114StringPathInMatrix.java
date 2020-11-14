package com.vv;

/**
 * @author ShenZhenWei
 * @date 2020/11/14
 */
class Day1114StringPathInMatrix {
    public static void main(String[] args) {
    }

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int i, int j, int index) {
        int len = board.length;
        int height = board[0].length;
        if (i >= len || j >= height || i < 0 || j < 0 || words[index] != board[i][j]) {
            return false;
        }

        //一些逻辑
        if (index == words.length - 1) {
            return true;
        }

        char tmp = board[i][j];
        board[i][j] = '.';
        boolean result;
        //往右
        result = dfs(board, words, i + 1, j, index + 1)
                // 往左
                || dfs(board, words, i - 1, j, index + 1)
                //往上
                || dfs(board, words, i, j - 1, index + 1)
                //往下
                || dfs(board, words, i, j + 1, index + 1);
        board[i][j] = tmp;
        return result;
    }
}
