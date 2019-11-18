package com.leetcode.greedy.algorithm;

/**
 * @author shine10076
 * 2019/11/15 10:51
 */
public class 工厂生产 {

    public static int[] product(int[] c, int[] y){
        int[] product = new int[c.length];
        int t = 0;
        product[t] += y[0];
        for(int i=1;i<y.length;i++){
            /*比较一下最小成本*/
            if((c[t]+(i-t)) > c[i]){
                t = i;
            }
            product[t] += y[i];
        }

        return product;
    }

    public static void main(String[] args) {
        int[] c = new int[]{2,5,3};
        int[] y = new int[]{2,4,5};
        for(int i : product(c,y)){
            System.out.printf(i+" ");
        }
    }
}
