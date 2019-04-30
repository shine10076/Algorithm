package com.leetcode.tree.algorithm;

/**
 * @author shine10076
 * @date 2019/4/28 15:15
 */
public class 将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sorterArrayToBSTByMid(nums,0, nums.length-1);
    }

    private TreeNode sorterArrayToBSTByMid(int[] nums, int L , int R)
    {
        if(L < R)
        {
            int mid = L + ((R-L)>>1);
            TreeNode root = new TreeNode(nums[mid]);
            root.left = sorterArrayToBSTByMid(nums,L, mid-1);
            root.right = sorterArrayToBSTByMid(nums,mid+1,R);
            return root;
        }
        else if(L == R )
        {
            return new TreeNode(nums[L]);
        }
        else
        {
            return null;
        }
    }
}
