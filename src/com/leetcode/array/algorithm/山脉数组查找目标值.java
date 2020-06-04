package com.leetcode.array.algorithm;

/**
 * @author shine10076
 * @date 2020/4/29 11:44
 */
public class 山脉数组查找目标值 {

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        int L = 0, R = length-1;
        int max = -1;
        while(L <= R){
            int mid = L + ((R-L)>>>1);
            if(mid == 0) {
                L = mid + 1;
                continue;
            }else if(mid == length-1){
                R = mid -1;
                continue;
            }
            int m = mountainArr.get(mid);
            int l = mountainArr.get(mid-1);
            int r = mountainArr.get(mid+1);
            if(m>l && m > r) {
               max = mid;
               break;
            }else if(m < l){
                R = mid-1;
            }else {
                L = mid+1;
            }
        }
        int res = findIndex(target,mountainArr,0,max);
        if(res != -1) return res;
        res = findIndexDesc(target,mountainArr,max+1,length-1);
        return res;

    }


    private int findIndex(int target, MountainArray mountainArray,int L, int R){
        while (L <= R){
            int mid = L + ((R-L)>>>1);
            int m = mountainArray.get(mid);
            if(m  == target ) return mid;
            else if(m < target){
                L = mid+1;
            }else {
                R = mid-1;
            }
        }
        return -1;
    }

    private int findIndexDesc(int target, MountainArray mountainArray,int L, int R){
        while (L <= R){
            int mid = L + ((R-L)>>>1);
            int m = mountainArray.get(mid);
            if(m  == target ) return mid;
            else if(m > target){
                L = mid+1;
            }else {
                R = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MountainArrayImples m = new MountainArrayImples(new int[]{3,5,3,2,0});
        山脉数组查找目标值 a = new 山脉数组查找目标值();
        int res = a.findInMountainArray(0,m);
        System.out.println(res);
    }
}

interface MountainArray{
    public int get(int index);
    public int length();
}

class MountainArrayImples implements MountainArray{
    int[] array;

    @Override
    public int length() {
        return array.length;
    }

    @Override
    public int get(int index){
        return array[index];
    }

    public MountainArrayImples(int[] a) {
        array = a.clone();

    }
}

