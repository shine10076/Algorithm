package com.leetcode.array.algorithm;

/**
 * @author shine10076
 * @date 2019/9/30 14:23
 */
public class 生命游戏 {


    int[][] directions = new int[][]{
            {1,0},{1,1},{1,-1},{-1,0},{-1,1},{-1,-1},{0,-1},{0,1}
    };


    public void gameOfLife(int[][] board) {

        if(board == null || board.length == 0)
        {
            return;
        }
        int M = board.length;
        int N = board[0].length;

        for(int i=0;i<M;i++)
        {
            for(int j=0;j<N;j++)
            {
                changeState(board,i,j,M,N);
            }
        }

        for(int i=0;i<M;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(board[i][j] == 2)
                {
                    board[i][j] = 1;
                }else if(board[i][j] == 3)
                {
                    board[i][j]=0;
                }
            }
        }



    }

    private void changeState(int[][] board, int i, int j, int M, int N)
    {
        int count = 0;
        for(int[] direction : directions)
        {
            if(i+direction[0]>=M || i+direction[0]<0 ||j+direction[1]>=N || j+direction[1] < 0)
            {
                continue;
            }
            if(board[i+direction[0]][j+direction[1]] == 1 || board[i+direction[0]][j+direction[1]] == 3 )
            {
                count++;
            }
        }
        if(board[i][j] == 1 && (count<2 || count>3))
        {
            board[i][j] = 3;
        }
        else if(board[i][j] == 0 && (count > 3))
        {
            board[i][j] = 2;
        }
    }

}
