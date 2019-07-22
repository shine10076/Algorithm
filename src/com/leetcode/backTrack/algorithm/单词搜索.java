package com.leetcode.backTrack.algorithm;

/**
 * @author shine10076
 * @date 2019/7/22 20:44
 */
public class 单词搜索 {

    private static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static boolean exist(char[][] board, String word) {
        if(board == null  || board.length == 0)
        {
            return false;
        }

            int m = board.length, n = board[0].length;
            boolean[][] isVisit = new boolean[m][n];
            for(int i=0;i<m;i++)
                for(int j=0;j<n;j++)
                {
                    if(dfs(board,isVisit,word,i,j))
                    {
                        return true;
                    }
                }

                return false;
    }

    public static boolean dfs(char[][] board, boolean[][] isVisit, String word, int i, int j)
    {
        int m = board.length, n = board[0].length;
        if(word.length() == 0) return true;
        if(i<0 || i>= m || j<0 || j>=n || isVisit[i][j]||board[i][j] != word.charAt(0))
        {
            return false;
        }
        isVisit[i][j] = true;
        for(int[] d : direction)
        {
                if( dfs(board,isVisit,word.length()>1?word.substring(1):"",i+d[0],j+d[1]))
                {
                    return true;
                }
        }
        isVisit[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };

        System.out.println(exist(board,"ABCESEEEFS"));
    }
}
