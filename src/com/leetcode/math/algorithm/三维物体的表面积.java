package com.leetcode.math.algorithm;

/**
 * @author shine10076
 * @date 2020/3/25 20:32
 */
public class 三维物体的表面积 {

    static int[][] direction = new int[][]{
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };
    public static int surfaceArea(int[][] grid) {
        if(grid.length < 1){
            return 0;
        }
        int count = 0;
        int difference = 0;
        int m = grid.length, n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                count += grid[i][j];
                difference += grid[i][j]>1 ? (grid[i][j]-1)*2 : 0;
                for(int[] d : direction){
                    if(i+d[0]>=0&&i+d[0]<m&&j+d[1]>=0&&j+d[1]<n){
                        difference += Math.min(grid[i][j], grid[i+d[0]][j+d[1]]);
                    }
                }
            }
        }
        return count*6-difference;

    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,0},
                {0,2}
        };
        surfaceArea(grid);
    }
}
