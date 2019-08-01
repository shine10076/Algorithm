package com.offer.algorithm;

/**
 * @author shine10076
 * @date 2019/8/1 13:58
 */
public class 二叉搜索树的后序遍历序列 {


    /**
     * 二叉搜索树 左<根<右 输入序列数字全不相同
     * @param sequence ：序列
     * @return
     */
    public static boolean VerifySquenceOfBST(int [] sequence) {

        if(sequence == null || sequence.length == 0) return false;

        return isBST(sequence,0,sequence.length-1);
    }

    public static boolean isBST(int[] sequence, int l, int r)
    {
        if(l>=r) return true;

        int root = sequence[r];
        int mid = l;
        for(int i=l;i<=r;i++)
        {
            if(sequence[i]>=root)
            {
                mid = i-1;
                break;
            }
        }

        for(int i=mid+1;i<r;i++)
        {
            if(sequence[i]<root) return false;
        }
        return isBST(sequence,l,mid)&&isBST(sequence,mid+1,r-1);
    }

    public static void main(String[] args) {
        int[] sequence = new int[]{

        };

        System.out.println(VerifySquenceOfBST(sequence));
    }
}
