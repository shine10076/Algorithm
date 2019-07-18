package com.leetcode.Search.algorithm;

/**
 * @author shine10076
 * @date 2019/7/18 13:12
 */
public class 被围绕的区域 {

    /**
     * 从边界开始找和边界的O相连的O并且标记
     * @param board
     */
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        boolean[][] isMark = new boolean[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                /**
                 * 检查边界
                 */
                if(i==0 || i==m-1 || j == 0 || j==n-1){
                    if(board[i][j] == 'O' && !isMark[i][j])
                    {
                        isMark[i][j] = true;
                        dfs(board,i,j,isMark);
                    }
                }
            }

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                if(!isMark[i][j])
                {
                    board[i][j] = 'X';
                }
            }

    }

    public void dfs(char[][] board, int i, int j, boolean[][] isMark){
        int m = board.length, n = board[0].length;
        if(i+1<m && board[i+1][j] == 'O'&& !isMark[i+1][j])
        {
            isMark[i+1][j] = true;
            dfs(board,i+1,j,isMark);
        }
        if(j+1<n && board[i][j+1] == 'O' && !isMark[i][j+1])
        {
            isMark[i][j+1] = true;
            dfs(board,i,j+1,isMark);
        }
        if(i-1>=0 && board[i-1][j]=='O'&& !isMark[i-1][j])
        {
            isMark[i-1][j]= true;
            dfs(board,i-1,j,isMark);
        }
        if(j-1>=0 && board[i][j-1] == 'O' && !isMark[i][j-1])
        {
            isMark[i][j-1] = true;
            dfs(board,i,j-1,isMark);
        }

    }
}
