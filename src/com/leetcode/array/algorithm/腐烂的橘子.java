package com.leetcode.array.algorithm;

/**
 * @author shine10076
 * @date 2020/3/4 11:53
 */
public class 腐烂的橘子 {

    public static int[][] direction = new int[][]{
            {1, 0},
            {-1,0},
            {0,1},
            {0,-1},
    };


    public static int orangesRotting(int[][] grid) {
        if(grid == null || grid.length < 1) return -1;

        boolean isRotting = true;
        int res = 0;
        while (isRotting){
            isRotting = false;
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j] == 1){
                        rotting(grid,i,j);
                    }
                }
            }

            for(int i=0;i<grid.length;i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] == 3){
                        grid[i][j] = 2;
                        isRotting = true;
                    }
                }
            }
            if(isRotting) res++;
        }

        for(int i=0;i<grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) return -1;
            }
        }

        return res;

    }

    public static void rotting(int[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        for(int[] d : direction){
            if(i+d[0]>=0 && i+d[0]< m && j+d[1] >= 0 && j+d[1] < n && grid[i+d[0]][j+d[1]] == 2){
                grid[i][j] = 3;
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,2}
        };
        System.out.println(orangesRotting(grid));


    }


}
