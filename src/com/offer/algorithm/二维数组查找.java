package com.offer.algorithm;

/**
 * @author shine10076
 * @date 2020/8/10 10:57
 */
public class 二维数组查找 {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1){
            return false;
        }



        int m = matrix.length;
        int n = matrix[0].length;

        int x = n-1;
        int y = 1;

        while(x >= 0 && y <m){
            if(matrix[y][x] == target){
                return true;
            }else if(matrix[y][x] > target){
                y++;
            }else{
                x--;
            }
        }

        return false;
    }

}
