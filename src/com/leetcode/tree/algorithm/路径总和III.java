package com.leetcode.tree.algorithm;

/**
 * @author shine10076
 * @date 2019/10/16 14:25
 */
public class 路径总和III {

    public  int pathSum(TreeNode root, int sum) {

        if(root == null) {
            return 0;
        }


        return   paths(root,sum)
                +pathSum(root.left,sum)+pathSum(root.right,sum);

    }

    public int paths(TreeNode root, int sum)
    {

        if(root == null) return 0;

        int res = 0;

        if(root.val == sum)
        {
            res += 1;
        }

        res += paths(root.left,sum-root.val);
        res += paths(root.right,sum-root.val);

        return res;
    }

}
