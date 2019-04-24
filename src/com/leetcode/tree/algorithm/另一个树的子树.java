package com.leetcode.tree.algorithm;

/**
 * @author shine10076
 * @date 2019/4/14 20:20
 */
public class 另一个树的子树 {

    /*判断t是否是s的子树*/
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null&&t==null) return true;
        if(s==null||t==null) return false;
        if(isEqual(s,t)) return true;
        return isSubtree(s.left, t)|| isSubtree(s.right, t);
    }

    private boolean isEqual(TreeNode s, TreeNode t)
    {
        if(s == null && t == null) return true;
        if(s ==null || t== null) return false;
        if(s.val == t.val)
            return isEqual(s.left, t.left)&&isEqual(s.right, t.right);
        else
            return false;
    }
}
